package com.work.navigation

sealed class BookmarkScreenRoute(val route: String) {
    object Main : BookmarkScreenRoute("bookmarks_main")
    object Details : BookmarkScreenRoute("bookmarks_article_details/{articleId}") {
        fun createRoute(articleId: String) = "bookmarks_article_details/$articleId"
    }
}

