package com.brafik.famous.features.login.models

data class LoginViewState(
    val email: String = "email",
    val password: String = "pass",
    val isSending: Boolean = false
)