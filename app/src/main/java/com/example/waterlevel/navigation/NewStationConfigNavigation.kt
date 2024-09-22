package com.example.waterlevel.navigation

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.waterlevel.ui.screen.NewStationConfigScreen

internal const val BARCODE_STRING = "barcodeString"

internal class BarcodeArgs(val barcodeString: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(checkNotNull(savedStateHandle.get<String>(BARCODE_STRING)))
}

const val newStationConfigNavigationRoute = "new_station_config"

fun NavController.navigateToNewStationConfig(barcodeString: String ){
    val encodedId = Uri.encode(barcodeString)
    this.navigate("$newStationConfigNavigationRoute/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.newStationConfigGraph(
    onBackClick: () -> Unit
){
    composable(route = newStationConfigNavigationRoute){
        NewStationConfigScreen(onBackClick = onBackClick)
    }
}