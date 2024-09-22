package com.example.waterlevel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.waterlevel.ui.screen.AppState

@Composable
fun AppNavHost(
    appState: AppState,
    startDestination: String = stationListGraphRoute
) {
    val navController = appState.navController
    NavHost(navController = navController, startDestination = startDestination) {
        stationListGraph(
            nestedGraph = {}
        )
        addStationGraph(
            onBarcodeScanned = {navController.navigateToNewStationConfig(it)},
            nestedGraph = {

            }
        )
        settingsGraph(
            nestedGraph = {}
        )
    }
}