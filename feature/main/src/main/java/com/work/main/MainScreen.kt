package com.work.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.work.auth.authNavGraph
import com.work.main.bottomNavigation.BottomNavScreen
import com.work.navigation.Graph

@Composable
fun MainScreen(isUserAuthenticated: Boolean = false) {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        route = Graph.ROOT_GRAPH,
        startDestination = if (isUserAuthenticated) Graph.BOTTOM_NAV_GRAPH else Graph.AUTH_GRAPH
    ) {
        authNavGraph(
            onAuthSuccess = {
                rootNavController.navigate(Graph.BOTTOM_NAV_GRAPH) {
                    popUpTo(Graph.AUTH_GRAPH) { inclusive = true }
                }
            }
        )

        composable(route = Graph.BOTTOM_NAV_GRAPH) {
            BottomNavScreen()
        }
    }
}
