package com.work.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.work.screens.ArticleDetailsScreen
import com.work.screens.home.HomeScreen

sealed class HomeScreenRoute(val route: String) {
    object Main : HomeScreenRoute("home_main")
    object Details : HomeScreenRoute("home_article_details/{articleId}") {
        fun createRoute(articleId: String) = "home_article_details/$articleId"
    }
}


fun NavGraphBuilder.homeNavGraph(
    onNavigateToDetails: (String) -> Unit,
    onBack: () -> Unit
) {
    navigation(
        route = Graph.HOME_GRAPH,
        startDestination = HomeScreenRoute.Main.route
    ) {
        composable(route = HomeScreenRoute.Main.route) {
            HomeScreen(onNavigateToDetails = onNavigateToDetails)
        }
        composable(route = HomeScreenRoute.Details.route) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getString("articleId").orEmpty()
            ArticleDetailsScreen(articleId = articleId, onBack = onBack)
        }
    }
}