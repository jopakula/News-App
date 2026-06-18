package com.work.bookmarks

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bookmarksFeatureModule = module {
    viewModel { BookmarksViewModel(repository = get()) }
}