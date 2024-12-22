package com.brafik.famous.features.login.models

data class LoginViewState(
    val email: String = "",
    val password: String = "",
    val isSending: Boolean = false
)