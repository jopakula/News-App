package com.work.main.bottomNavigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavScreen() {
    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = bottomNavController) }
    ) { padding ->
        BottomNavGraph(
            modifier = Modifier.padding(padding),
            navController = bottomNavController
        )
    }
}
