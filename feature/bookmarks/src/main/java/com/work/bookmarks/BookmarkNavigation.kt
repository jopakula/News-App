package com.work.bookmarks

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.work.details.ArticleDetailsScreen
import com.work.domain.NewsRepository
import com.work.navigation.BookmarkScreenRoute
import com.work.navigation.Graph

fun NavGraphBuilder.bookmarkNavGraph(
    repository: NewsRepository,
    onNavigateToDetails: (String) -> Unit,
    onBack: () -> Unit
) {
    navigation(
        route = Graph.BOOKMARKS_GRAPH,
        startDestination = BookmarkScreenRoute.Main.route
    ) {
        composable(route = BookmarkScreenRoute.Main.route) {

            val bookmarksViewModel: BookmarksViewModel = viewModel(
                factory = viewModelFactory {
                    initializer {
                        BookmarksViewModel(repository = repository)
                    }
                }
            )

            BookmarksScreen(
                viewModel = bookmarksViewModel,
                onNavigateToDetails = onNavigateToDetails
            )
        }
        composable(route = BookmarkScreenRoute.Details.route) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getString("articleId").orEmpty()
            ArticleDetailsScreen(articleId = articleId, onBack = onBack)
        }
    }
}