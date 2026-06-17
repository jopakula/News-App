package com.work.home

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.work.details.ArticleDetailsScreen
import com.work.domain.NewsRepository
import com.work.navigation.Graph
import com.work.navigation.HomeScreenRoute

fun NavGraphBuilder.homeNavGraph(
    repository: NewsRepository,
    onNavigateToDetails: (String) -> Unit,
    onBack: () -> Unit
) {
    navigation(
        route = Graph.HOME_GRAPH,
        startDestination = HomeScreenRoute.Main.route
    ) {
        composable(route = HomeScreenRoute.Main.route) {

            val homeViewModel: HomeViewModel = viewModel(
                factory = viewModelFactory {
                    initializer {
                        HomeViewModel(repository = repository)
                    }
                }
            )

            HomeScreen(
                viewModel = homeViewModel,
                onNavigateToDetails = onNavigateToDetails
            )
        }
        composable(route = HomeScreenRoute.Details.route) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getString("articleId").orEmpty()
            ArticleDetailsScreen(articleId = articleId, onBack = onBack)
        }
    }
}