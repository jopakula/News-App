package com.work.auth

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authFeatureModule = module {
    viewModel { LoginViewModel(authRepository = get()) }
}