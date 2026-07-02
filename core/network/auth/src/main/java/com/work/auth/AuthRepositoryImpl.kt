package com.work.auth

import android.util.Log
import com.work.domain.AuthRepository
import com.work.domain.LoginRequestDomain
import com.work.domain.LoginResponseDomain

class AuthRepositoryImpl(
    private val authApi: DummyJsonAuthApi
) : AuthRepository {

    override suspend fun login(request: LoginRequestDomain): LoginResponseDomain {
        return try {
            // 1. Конвертируем доменную модель запроса в сетевую DTO (используя extension)
            val networkRequest = request.toNetwork()

            // 2. Делаем сетевой запрос через Retrofit
            val networkResponse = authApi.login(networkRequest)

            // 3. Сохраняем полученные токены в синглтон сетевого сервиса
            DummyJsonNetworkService.accessToken = networkResponse.accessToken
            DummyJsonNetworkService.refreshToken = networkResponse.refreshToken

            Log.d(
                LOG_TAG,
                "Токены сохранены в NetworkService. AccessToken: ${
                    networkResponse.accessToken.take(10)
                }..."
            )

            // 4. Возвращаем чистую доменную модель для UseCase/UI
            networkResponse.toDomain()

        } catch (e: Exception) {
            Log.e(LOG_TAG, "Ошибка во время выполнения login запроса: ${e.message}")
            throw e
        }
    }
}

// Маппим доменную модель запроса в сетевую DTO
fun LoginRequestDomain.toNetwork(): LoginRequest {
    return LoginRequest(
        username = this.username,
        password = this.password
    )
}

// Маппим сетевой ответ API в чистую доменную модель для UseCase/UI
fun LoginResponse.toDomain(): LoginResponseDomain {
    return LoginResponseDomain(
        id = this.id,
        username = this.username,
        email = this.email,
        firstName = this.firstName,
        lastName = this.lastName,
        gender = this.gender,
        image = this.image
    )
}