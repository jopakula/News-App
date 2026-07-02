package com.work.main.bottomNavigation

import com.work.main.R
import com.work.navigation.Graph

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: Int
) {

    object Home : BottomBarScreens(
        route = Graph.HOME_GRAPH,
        title = "Home",
        icon = R.drawable.home_icon
    )

    object Bookmarks : BottomBarScreens(
        route = Graph.BOOKMARKS_GRAPH,
        title = "Bookmarks",
        icon = R.drawable.bookmark_icon
    )

    object Profile : BottomBarScreens(
        route = Graph.PROFILE_GRAPH,
        title = "Profile",
        icon = R.drawable.profile_icon
    )
}
