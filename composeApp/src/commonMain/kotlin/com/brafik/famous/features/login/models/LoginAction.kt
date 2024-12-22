package com.brafik.famous.features.login.models

sealed class LoginAction {
    data object OpenMainScreen : LoginAction()
}