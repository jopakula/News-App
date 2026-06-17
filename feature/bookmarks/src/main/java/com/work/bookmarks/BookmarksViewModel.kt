package com.work.bookmarks

import androidx.lifecycle.ViewModel
import com.work.domain.FakeArticle
import com.work.domain.NewsRepository

class BookmarksViewModel(private val repository: NewsRepository) : ViewModel() {
    val bookmarkedList: List<FakeArticle> = repository.getBookmarkedNews()
}