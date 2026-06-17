package com.work.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(onNavigateToDetails: (String) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Главная лента новостей")
        Button(onClick = { onNavigateToDetails("news_from_home_1") }) {
            Text(text = "Открыть новость #1")
        }
    }
}

@Composable
@Preview
private fun ScreenPreview() {
    HomeScreen()
}
