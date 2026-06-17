package com.work.data

import com.work.domain.FakeArticle
import com.work.domain.NewsRepository

class MockNewsRepositoryImpl : NewsRepository {

    private val fakeNews = listOf(
        FakeArticle(
            1,
            "Android 17 получил революционное обновление системы корутин",
            "Технологии",
            "10 мин. назад"
        ),
        FakeArticle(
            2,
            "Сборная выиграла главный матч сезона в добавленное время",
            "Спорт",
            "18 мин. назад"
        ),
        FakeArticle(
            3,
            "Индекс технологических компаний обновил исторический максимум",
            "Финансы",
            "1 час назад"
        )
    )

    override fun getNews(): List<FakeArticle> {
        return fakeNews
    }

    override fun getBookmarkedNews(): List<FakeArticle> {
        return fakeNews.filter { it.id == 1 || it.id == 3 }
    }
}