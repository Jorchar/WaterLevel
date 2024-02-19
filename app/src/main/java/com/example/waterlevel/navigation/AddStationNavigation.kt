package com.example.waterlevel.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.waterlevel.ui.screen.AddStationScreen

const val addStationGraphRoute = "add_station_list_graph"
const val addStationNavigationRoute = "add_station_list"

fun NavController.navigateToAddStation(navOptions: NavOptions? = null){
    this.navigate(addStationGraphRoute, navOptions)
}

fun NavGraphBuilder.addStationGraph(
    nestedGraph: NavGraphBuilder.() -> Unit
){
    navigation(
        route = addStationGraphRoute,
        startDestination = addStationNavigationRoute
    ){
        composable(route = addStationNavigationRoute){
            AddStationScreen()
        }
        nestedGraph()
    }
}