package com.example.waterlevel.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.waterlevel.data.model.Plant

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PlantItem(
    plant: Plant,
    //onClickAction: OnClickAction
) {
    ListItem(
        headlineText = { Text(text = plant.name) },
        leadingContent = { GlideImage(model = plant.plantImage, contentDescription = plant.name)}
    )
}