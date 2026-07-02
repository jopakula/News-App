package com.work.domain

interface AuthRepository {
    suspend fun login(request: LoginRequestDomain): LoginResponseDomain
}

data class LoginRequestDomain(
    val username: String,
    val password: String,
)

data class LoginResponseDomain(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
)
