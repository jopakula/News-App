package com.work.newsapp

import android.app.Application
import com.work.auth.authFeatureModule
import com.work.auth.authModule
import com.work.bookmarks.bookmarksFeatureModule
import com.work.data.dataModule
import com.work.domain.domainModule
import com.work.home.homeFeatureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NewsApplication)
            modules(
                listOf(
                    domainModule,
                    dataModule,
                    authModule,
                    authFeatureModule,
                    homeFeatureModule,
                    bookmarksFeatureModule
                )
            )
        }
    }
}