package com.work.domain.fakeData

//// Что отправляем при логине
//@Serializable
//data class LoginRequest(
//    val username: String, // В доке: "emilys"
//    val password: String,  // В доке: "emilyspassword"
//    val expiresInMins: Int = 1
//)
//
//// Что получаем при успешном логине
//@Serializable
//data class LoginResponse(
//    val id: Int,
//    val username: String,
//    val email: String,
//    val firstName: String,
//    val lastName: String,
//    val gender: String,
//    val image: String,
//    val accessToken: String,
//    val refreshToken: String
//)
//
//@Serializable
//data class RefreshRequest(
//    val refreshToken: String,
//    val expiresInMins: Int = 1 // Каждую минуту токен будет тухнуть
//)
//
//@Serializable
//data class RefreshResponse(
//    val accessToken: String,
//    val refreshToken: String
//)
//
//// Защищенный объект профиля (эндпоинт /auth/me)
//@Serializable
//data class UserProfile(
//    val id: Int,
//    val username: String,
//    val email: String,
//    val firstName: String,
//    val lastName: String
//)