package com.example.waterlevel.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.waterlevel.navigation.TopLevelDestination
import com.example.waterlevel.navigation.navigateToAddStation
import com.example.waterlevel.navigation.navigateToSettings
import com.example.waterlevel.navigation.navigateToStationList
import com.example.waterlevel.navigation.stationListNavigationRoute

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
) :AppState {
    return remember(navController){
        AppState(navController)
    }
}

@Stable
class AppState (
    val navController: NavHostController
){
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            stationListNavigationRoute -> TopLevelDestination.STATIONS_LIST
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
        when (topLevelDestination) {
            TopLevelDestination.STATIONS_LIST -> navController.navigateToStationList(
                topLevelNavOptions
            )

            TopLevelDestination.ADD_STATION -> navController.navigateToAddStation(
                topLevelNavOptions
            )

            TopLevelDestination.SETTINGS -> navController.navigateToSettings(
                topLevelNavOptions
            )
        }
    }
}
