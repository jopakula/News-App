package com.work.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.work.navigation.Graph
import com.work.navigation.ProfileScreenRoute

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