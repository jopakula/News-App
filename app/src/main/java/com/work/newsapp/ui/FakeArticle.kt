package com.work.newsapp.ui

data class FakeArticle(
    val id: Int,
    val title: String,
    val category: String,
    val time: String
)

val fakeNews = listOf(
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