package com.example.waterlevel.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelDestination (
    val icon: ImageVector,
    val titleText: String
){
    STATIONS_LIST(
        icon = Icons.Filled.Star,
        titleText = "Stations list"
    ),
    SETTINGS(
        icon = Icons.Filled.Settings,
        titleText = "Settings"
    ),
    ADD_STATION(
        icon = Icons.Filled.Build,
        titleText = "Add station"
    )
}