package com.work.navigation

sealed class HomeScreenRoute(val route: String) {
    object Main : HomeScreenRoute("home_main")
    object Details : HomeScreenRoute("home_article_details/{articleId}") {
        fun createRoute(articleId: String) = "home_article_details/$articleId"
    }
}