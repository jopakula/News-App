package com.work.main.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.work.bookmarks.bookmarkNavGraph
import com.work.home.homeNavGraph
import com.work.navigation.BookmarkScreenRoute
import com.work.navigation.Graph
import com.work.navigation.HomeScreenRoute
import com.work.profile.profileNavGraph

@Composable
fun BottomNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        route = Graph.BOTTOM_NAV_GRAPH,
        startDestination = BottomBarScreens.Home.route
    ) {
        homeNavGraph(
            onNavigateToDetails = { articleId ->
                navController.navigate(HomeScreenRoute.Details.createRoute(articleId))
            },
            onBack = { navController.popBackStack() }
        )

        bookmarkNavGraph(
            onNavigateToDetails = { articleId ->
                navController.navigate(BookmarkScreenRoute.Details.createRoute(articleId))
            },
            onBack = { navController.popBackStack() }
        )

        profileNavGraph()
    }
}