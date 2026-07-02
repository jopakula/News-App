package com.work.auth

import com.work.domain.AuthRepository
import org.koin.dsl.module

val authModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(authApi = DummyJsonNetworkService.authApi)
    }
}