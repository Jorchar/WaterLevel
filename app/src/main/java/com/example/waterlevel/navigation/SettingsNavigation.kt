package com.example.waterlevel.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.waterlevel.ui.screen.SettingsScreen

const val settingsGraphRoute = "settings_list_graph"
const val settingsNavigationRoute = "settings_list"

fun NavController.navigateToSettings(navOptions: NavOptions? = null){
    this.navigate(settingsGraphRoute, navOptions)
}

fun NavGraphBuilder.settingsGraph(
    nestedGraph: NavGraphBuilder.() -> Unit
){
    navigation(
        route = settingsGraphRoute,
        startDestination = settingsNavigationRoute
    ){
        composable(route = settingsNavigationRoute){
            SettingsScreen()
        }
        nestedGraph()
    }
}