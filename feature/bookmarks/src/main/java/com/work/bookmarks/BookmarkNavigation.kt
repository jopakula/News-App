package com.work.bookmarks

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.work.details.ArticleDetailsScreen
import com.work.navigation.BookmarkScreenRoute
import com.work.navigation.Graph

fun NavGraphBuilder.bookmarkNavGraph(
    onNavigateToDetails: (String) -> Unit,
    onBack: () -> Unit
) {
    navigation(
        route = Graph.BOOKMARKS_GRAPH,
        startDestination = BookmarkScreenRoute.Main.route
    ) {
        composable(route = BookmarkScreenRoute.Main.route) {


            BookmarksScreen(
                onNavigateToDetails = onNavigateToDetails
            )
        }
        composable(route = BookmarkScreenRoute.Details.route) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getString("articleId").orEmpty()
            ArticleDetailsScreen(articleId = articleId, onBack = onBack)
        }
    }
}