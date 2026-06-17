package com.work.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun BottomNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        route = Graph.ROOT,
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