package com.work.newsapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.work.navigation.BottomNavGraph
import com.work.navigation.BottomNavigationBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { padding ->
        BottomNavGraph(
            modifier = Modifier.padding(padding),
            navController = navController
        )
    }
}
