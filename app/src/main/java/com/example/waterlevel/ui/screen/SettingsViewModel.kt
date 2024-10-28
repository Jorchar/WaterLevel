package com.example.waterlevel.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waterlevel.data.Repository
import com.example.waterlevel.data.model.previewPlant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    fun addPlant() {
        viewModelScope.launch {
            repository.addPlant(previewPlant)
            println("Plant added")
        }
    }
}