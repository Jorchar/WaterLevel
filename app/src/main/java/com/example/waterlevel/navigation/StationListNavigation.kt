package com.example.waterlevel.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.waterlevel.ui.screen.StationsListScreen

const val stationListGraphRoute = "station_list_graph"
const val stationListNavigationRoute = "station_list"

fun NavController.navigateToStationList(navOptions: NavOptions? = null){
    this.navigate(stationListGraphRoute, navOptions)
}

fun NavGraphBuilder.stationListGraph(
    nestedGraph: NavGraphBuilder.() -> Unit
){
    navigation(
        route = stationListGraphRoute,
        startDestination = stationListNavigationRoute
    ){
        composable(route = stationListNavigationRoute){
            StationsListScreen()
        }
        nestedGraph()
    }
}