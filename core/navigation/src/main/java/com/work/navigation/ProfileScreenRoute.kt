package com.work.navigation

sealed class ProfileScreenRoute(val route: String) {
    object Main : ProfileScreenRoute("profile_main")
}