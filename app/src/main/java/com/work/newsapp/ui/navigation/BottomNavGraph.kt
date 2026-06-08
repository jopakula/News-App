package com.work.newsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.work.features.BookmarksScreen
import com.work.features.HomeScreen
import com.work.features.ProfileScreen

@Composable
fun BottomNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomBarScreens.Home.route
    ) {
        composable(route = BottomBarScreens.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreens.Bookmarks.route) {
            BookmarksScreen()
        }
        composable(route = BottomBarScreens.Profile.route) {
            ProfileScreen()
        }

    }
}