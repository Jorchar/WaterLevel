package com.example.waterlevel.ui.screen

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.waterlevel.data.model.Plant
import com.example.waterlevel.ui.component.PlantItem
import com.example.waterlevel.ui.theme.WaterLevelTheme

@Composable
fun StationsListScreen (
    viewModel: StationsListViewModel = hiltViewModel(),
){
    val plants by viewModel.plants.collectAsState(initial = emptyList())
    StationsListDetails(plants = plants)
}

@Composable
fun StationsListDetails(plants: List<Plant>) {
    LazyVerticalGrid(columns = GridCells.Fixed(1)) {
        items(plants.size) { index ->
            PlantItem(plant = plants[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StationsListPreview() {
    WaterLevelTheme {
        AppOverlay()
    }
}