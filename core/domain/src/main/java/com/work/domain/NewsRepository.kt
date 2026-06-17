package com.work.domain

interface NewsRepository {
    fun getNews(): List<FakeArticle>
    fun getBookmarkedNews(): List<FakeArticle>
}