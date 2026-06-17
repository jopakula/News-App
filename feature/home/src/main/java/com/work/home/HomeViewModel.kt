package com.work.home

import androidx.lifecycle.ViewModel
import com.work.domain.FakeArticle
import com.work.domain.NewsRepository

class HomeViewModel(private val repository: NewsRepository) : ViewModel() {
    val newsList: List<FakeArticle> = repository.getNews()
}