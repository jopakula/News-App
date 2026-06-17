package com.work.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.work.screens.profile.ProfileScreen

sealed class ProfileScreenRoute(val route: String) {
    object Main : ProfileScreenRoute("profile_main")
}

fun NavGraphBuilder.profileNavGraph() {
    navigation(
        route = Graph.PROFILE_GRAPH,
        startDestination = ProfileScreenRoute.Main.route
    ) {
        composable(route = ProfileScreenRoute.Main.route) {
            ProfileScreen()
        }
    }
}