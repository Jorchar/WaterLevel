package com.example.waterlevel.ui.component

import android.util.Base64
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.waterlevel.data.model.Plant

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PlantItem(
    plant: Plant,
    //onClickAction: OnClickAction
) {
    val imageBytes: ByteArray = Base64.decode(plant.photo, Base64.DEFAULT)
    ListItem(
        headlineContent = { Text(text = plant.name) },
        leadingContent = {
            GlideImage(
                model = imageBytes,
                contentDescription = plant.name,
                contentScale = ContentScale.Fit
            )
        }
    )
}