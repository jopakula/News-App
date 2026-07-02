package com.work.home

import androidx.lifecycle.ViewModel
import com.work.domain.NewsRepository
import com.work.domain.fakeData.FakeArticle

class HomeViewModel(private val repository: NewsRepository) : ViewModel() {
    val newsList: List<FakeArticle> = repository.getNews()
}