package com.work.auth

import android.util.Log
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

const val LOG_TAG = "RETROFIT_AUTH"

object DummyJsonNetworkService {
    private const val BASE_URL = "https://dummyjson.com/"

    // Переменные для хранения токенов в памяти приложения (в рамках сессии)
    var accessToken: String? = null
    var refreshToken: String? = null

    private val jsonParser = Json { ignoreUnknownKeys = true }

    // Интерцептор, добавляющий токен, если он есть
    private val authInterceptor = Interceptor { chain ->
        val originalRequest = chain.request()

        if (accessToken == null) {
            return@Interceptor chain.proceed(originalRequest)
        }

        val authenticatedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $accessToken")
            .build()

        chain.proceed(authenticatedRequest)
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(HttpLoggingInterceptor { message ->
            Log.d(LOG_TAG, message)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(jsonParser.asConverterFactory("application/json".toMediaType()))
        .build()

    // Наш сервис для выполнения запросов авторизации
    val authApi: DummyJsonAuthApi = retrofit.create(DummyJsonAuthApi::class.java)
}