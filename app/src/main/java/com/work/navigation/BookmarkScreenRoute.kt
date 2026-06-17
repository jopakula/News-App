package com.work.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.work.screens.ArticleDetailsScreen
import com.work.screens.bookmark.BookmarksScreen

sealed class BookmarkScreenRoute(val route: String) {
    object Main : BookmarkScreenRoute("bookmarks_main")
    object Details : BookmarkScreenRoute("bookmarks_article_details/{articleId}") {
        fun createRoute(articleId: String) = "bookmarks_article_details/$articleId"
    }
}

fun NavGraphBuilder.bookmarkNavGraph(
    onNavigateToDetails: (String) -> Unit,
    onBack: () -> Unit
) {
    navigation(
        route = Graph.BOOKMARKS_GRAPH,
        startDestination = BookmarkScreenRoute.Main.route
    ) {
        composable(route = BookmarkScreenRoute.Main.route) {
            BookmarksScreen(onNavigateToDetails = onNavigateToDetails)
        }
        composable(route = BookmarkScreenRoute.Details.route) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getString("articleId").orEmpty()
            ArticleDetailsScreen(articleId = articleId, onBack = onBack)
        }
    }
}