package com.brafik.famous.features.login.models

sealed class LoginEvent {
    class EmailChanged(val newValue: String): LoginEvent()
    class PasswordChanged(val newValue: String): LoginEvent()
    data object SignUpClicked : LoginEvent()
    data object LoginClicked : LoginEvent()
}