package com.work.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.work.domain.AuthRepository
import com.work.domain.LoginRequestDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface LoginUiState {
    object Idle : LoginUiState          // Начальное состояние (ожидание ввода)
    object Loading : LoginUiState       // Показываем прогресс-бар
    object Success : LoginUiState       // Успешный вход, можно навигироваться дальше
    data class Error(val message: String) : LoginUiState // Ошибка (например, неверный пароль)
}

class LoginViewModel(
    private val authRepository: AuthRepository // Передаем интерфейс, Koin его подставит
) : ViewModel() {

    // Внутренний стейт для мутаций внутри ViewModel
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)

    // Публичный стейт только для чтения в Compose
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(usernameInput: String, passwordInput: String) {
        // Простая валидация на клиенте перед отправкой
        if (usernameInput.isBlank() || passwordInput.isBlank()) {
            _uiState.value = LoginUiState.Error("Поля не должны быть пустыми")
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = LoginUiState.Loading
            try {
                // Формируем доменную модель запроса
                val request = LoginRequestDomain(
                    username = usernameInput,
                    password = passwordInput
                )

                // Делаем запрос через репозиторий (токены сохранятся внутри NetworkService)
                authRepository.login(request)

                // Если дошли сюда и не упали в catch — всё прошло успешно
                _uiState.value = LoginUiState.Success
            } catch (e: Exception) {
                // Обрабатываем ошибку (сеть, 403, таймаут и т.д.)
                _uiState.value = LoginUiState.Error(e.localizedMessage ?: "Неизвестная ошибка")
            }
        }
    }

    // Метод для сброса стейта ошибки, если юзер снова начал вводить данные
    fun resetError() {
        if (_uiState.value is LoginUiState.Error) {
            _uiState.value = LoginUiState.Idle
        }
    }
}