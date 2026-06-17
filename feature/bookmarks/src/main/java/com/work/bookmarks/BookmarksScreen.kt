package com.work.bookmarks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.work.details.NewsCard

@Composable
fun BookmarksScreen(
    viewModel: BookmarksViewModel,
    onNavigateToDetails: (String) -> Unit = {}
) {

    val bookmarkedNews = viewModel.bookmarkedList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Сохраненные закладки",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        if (bookmarkedNews.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Закладок пока нет")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(bookmarkedNews) { article ->
                    NewsCard(
                        title = article.title,
                        category = article.category,
                        time = article.time,
                        onClick = { onNavigateToDetails(article.id.toString()) }
                    )
                }
            }
        }
    }
}

//@Composable
//@Preview
//private fun ScreenPreview() {
//    BookmarksScreen()
//}
