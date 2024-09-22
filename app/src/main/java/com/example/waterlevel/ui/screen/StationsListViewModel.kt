package com.example.waterlevel.ui.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waterlevel.data.model.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StationsListViewModel @Inject constructor(

): ViewModel() {
    val plants = MutableLiveData<List<Plant>>()

}