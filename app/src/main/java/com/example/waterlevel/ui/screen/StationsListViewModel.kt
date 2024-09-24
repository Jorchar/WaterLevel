package com.example.waterlevel.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waterlevel.data.Repository
import com.example.waterlevel.data.model.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationsListViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    private val _plants = MutableStateFlow<List<Plant>>(emptyList())
    val plants = _plants

    init {
        getAllPlants()
    }

    private fun getAllPlants() {
        viewModelScope.launch {
            repository.getAllPlants().flowOn(Dispatchers.IO).collect { plants: List<Plant> ->
                _plants.update { plants }
            }
        }
    }
}