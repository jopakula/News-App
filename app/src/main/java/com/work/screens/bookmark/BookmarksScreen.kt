package com.work.screens.bookmark

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
fun BookmarksScreen(onNavigateToDetails: (String) -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Сохраненные закладки")
        Button(onClick = { onNavigateToDetails("news_from_bookmarks_99") }) {
            Text(text = "Открыть сохраненную новость #99")
        }
    }
}
@Composable
@Preview
private fun ScreenPreview() {
    BookmarksScreen()
}
