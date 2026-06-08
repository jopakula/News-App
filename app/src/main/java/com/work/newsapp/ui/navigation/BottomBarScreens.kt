package com.work.newsapp.ui.navigation

import com.work.newsapp.R

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarScreens(
        route = "home",
        title = "Home",
        icon = R.drawable.home_icon
    )

    object Bookmarks : BottomBarScreens(
        route = "bookmarks",
        title = "Bookmarks",
        icon = R.drawable.bookmark_icon
    )

    object Profile : BottomBarScreens(
        route = "profile",
        title = "Profile",
        icon = R.drawable.profile_icon
    )
}
