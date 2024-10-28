package com.example.waterlevel.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.waterlevel.ui.component.PlantItem
import com.example.waterlevel.ui.theme.WaterLevelTheme

@Composable
fun StationsListScreen (
    viewModel: StationsListViewModel = hiltViewModel(),
){
    val plantsUiState: PlantsUiState by viewModel.plantsUiState.collectAsStateWithLifecycle()
    StationsListDetails(plantsUiState = plantsUiState)
}

@Composable
fun StationsListDetails(plantsUiState: PlantsUiState) {
        when (plantsUiState) {
            is PlantsUiState.Loading -> {
                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    CircularProgressIndicator()
                }
            }
            is PlantsUiState.Success -> {
                LazyVerticalGrid(columns = GridCells.Fixed(1)) {
                    items(plantsUiState.plants.size) { index ->
                        PlantItem(plant = plantsUiState.plants[index])
                    }
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun StationsListPreview() {
    WaterLevelTheme {
        AppOverlay()
        StationsListDetails(plantsUiState = PlantsUiState.Loading)
    }
}