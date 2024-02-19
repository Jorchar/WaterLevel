package com.example.waterlevel.ui.screen

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.waterlevel.data.model.previewPlant
import com.example.waterlevel.ui.component.PlantItem
import com.example.waterlevel.ui.theme.WaterLevelTheme

@Composable
fun StationsListScreen (){
    StationsListDetails()
}

@Composable
fun StationsListDetails() {
    LazyVerticalGrid(columns = GridCells.Fixed(1)) {
        items(
            count = 7,
            key = null
        ){
            PlantItem(previewPlant)
            PlantItem(previewPlant)
            PlantItem(previewPlant)
            PlantItem(previewPlant)
            PlantItem(previewPlant)
            PlantItem(previewPlant)
            PlantItem(previewPlant)
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