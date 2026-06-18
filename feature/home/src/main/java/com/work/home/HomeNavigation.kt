package com.work.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.work.details.ArticleDetailsScreen
import com.work.navigation.Graph
import com.work.navigation.HomeScreenRoute

fun NavGraphBuilder.homeNavGraph(
    onNavigateToDetails: (String) -> Unit,
    onBack: () -> Unit
) {
    navigation(
        route = Graph.HOME_GRAPH,
        startDestination = HomeScreenRoute.Main.route
    ) {
        composable(route = HomeScreenRoute.Main.route) {
            HomeScreen(
                onNavigateToDetails = onNavigateToDetails
            )
        }
        composable(route = HomeScreenRoute.Details.route) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getString("articleId").orEmpty()
            ArticleDetailsScreen(articleId = articleId, onBack = onBack)
        }
    }
}