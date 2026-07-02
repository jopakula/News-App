package com.work.bookmarks

import androidx.lifecycle.ViewModel
import com.work.domain.NewsRepository
import com.work.domain.fakeData.FakeArticle

class BookmarksViewModel(private val repository: NewsRepository) : ViewModel() {
    val bookmarkedList: List<FakeArticle> = repository.getBookmarkedNews()
}