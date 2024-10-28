package com.example.waterlevel.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waterlevel.data.Repository
import com.example.waterlevel.data.model.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class StationsListViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    val plantsUiState: StateFlow<PlantsUiState> = plantsUiState().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = PlantsUiState.Loading
    )

    private fun plantsUiState(): Flow<PlantsUiState> {
        val plantsStream: Flow<List<Plant>> = repository.getAllPlants()
        return plantsStream.map { plants ->
            PlantsUiState.Success(plants)
        }
    }
}

sealed interface PlantsUiState {
    data class Success(val plants: List<Plant>): PlantsUiState
    //data object Error: PlantsUiState
    data object Loading: PlantsUiState
}
