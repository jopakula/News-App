package com.work.newsapp.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val bottomScreens = listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Bookmarks,
        BottomBarScreens.Profile
    )

    NavigationBar {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        NavigationBarItem(
            label = { Text(text = BottomBarScreens.Home.title) },
            icon = {
                Icon(
                    painter = painterResource(id = BottomBarScreens.Home.icon),
                    contentDescription = BottomBarScreens.Home.title
                )
            },
            selected = currentRoute == BottomBarScreens.Home.route,
            onClick = {
                if (currentRoute != BottomBarScreens.Home.route) {
                    navController.navigate(BottomBarScreens.Home.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        )
        NavigationBarItem(
            label = { Text(text = BottomBarScreens.Bookmarks.title) },
            icon = {
                Icon(
                    painter = painterResource(id = BottomBarScreens.Bookmarks.icon),
                    contentDescription = BottomBarScreens.Bookmarks.title
                )
            },
            selected = currentRoute == BottomBarScreens.Bookmarks.route,
            onClick = {
                if (currentRoute != BottomBarScreens.Bookmarks.route) {
                    navController.navigate(BottomBarScreens.Bookmarks.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        )
        NavigationBarItem(
            label = { Text(text = BottomBarScreens.Profile.title) },
            icon = {
                Icon(
                    painter = painterResource(id = BottomBarScreens.Profile.icon),
                    contentDescription = BottomBarScreens.Profile.title
                )
            },
            selected = currentRoute == BottomBarScreens.Profile.route,
            onClick = {
                if (currentRoute != BottomBarScreens.Profile.route) {
                    navController.navigate(BottomBarScreens.Profile.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        )

//        bottomScreens.forEach { screen ->
//            NavigationBarItem(
//                label = { Text(text = screen.title) },
//                icon = {
//                    Icon(
//                        painter = painterResource(id = screen.icon),
//                        contentDescription = screen.title
//                    )
//                },
//                selected = currentRoute == screen.route,
//                onClick = {
//                    // Переключаем экран только если мы уже не на нем
//                    if (currentRoute != screen.route) {
//                        navController.navigate(screen.route) {
//                            // Очищаем стек до стартового экрана, чтобы не копить кучу экранов в памяти
//                            popUpTo(navController.graph.startDestinationId) {
//                                saveState = true
//                            }
//                            // Избегаем дублирования экранов при многократном нажатии
//                            launchSingleTop = true
//                            // Восстанавливаем состояние экрана (например, позицию скролла ленты)
//                            restoreState = true
//                        }
//                    }
//                }
//            )
//        }
    }
}