package com.work.auth

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DummyJsonAuthApi {

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("auth/me")
    suspend fun getCurrentUser(): UserProfile

}