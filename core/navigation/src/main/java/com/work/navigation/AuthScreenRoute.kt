package com.work.navigation

sealed class AuthScreenRoute(val route: String) {
    object Login : AuthScreenRoute("auth_login")
}