package com.work.data

import com.work.domain.NewsRepository
import org.koin.dsl.module

val dataModule = module {
    single<NewsRepository> { MockNewsRepositoryImpl() }
}