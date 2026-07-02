package com.work.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.work.navigation.AuthScreenRoute
import com.work.navigation.Graph

fun NavGraphBuilder.authNavGraph(onAuthSuccess: () -> Unit) {
    navigation(
        route = Graph.AUTH_GRAPH,
        startDestination = AuthScreenRoute.Login.route
    ) {
        composable(route = AuthScreenRoute.Login.route) {
            LoginScreen(onAuthSuccess = onAuthSuccess)
        }
    }
}