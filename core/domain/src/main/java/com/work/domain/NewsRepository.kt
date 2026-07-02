package com.work.domain

import com.work.domain.fakeData.FakeArticle

interface NewsRepository {
    fun getNews(): List<FakeArticle>
    fun getBookmarkedNews(): List<FakeArticle>
}