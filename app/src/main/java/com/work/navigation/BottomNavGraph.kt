package com.work.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.work.bookmarks.bookmarkNavGraph
import com.work.data.MockNewsRepositoryImpl
import com.work.domain.NewsRepository
import com.work.home.homeNavGraph
import com.work.profile.profileNavGraph

@Composable
fun BottomNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val newsRepository: NewsRepository = MockNewsRepositoryImpl()

    NavHost(
        modifier = modifier,
        navController = navController,
        route = Graph.ROOT,
        startDestination = BottomBarScreens.Home.route
    ) {
        homeNavGraph(
            repository = newsRepository,
            onNavigateToDetails = { articleId ->
                navController.navigate(HomeScreenRoute.Details.createRoute(articleId))
            },
            onBack = { navController.popBackStack() }
        )

        bookmarkNavGraph(
            repository = newsRepository,
            onNavigateToDetails = { articleId ->
                navController.navigate(BookmarkScreenRoute.Details.createRoute(articleId))
            },
            onBack = { navController.popBackStack() }
        )

        profileNavGraph()
    }
}