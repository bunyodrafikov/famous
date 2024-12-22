package com.brafik.famous.features.login

import com.brafik.famous.base.BaseViewModel
import com.brafik.famous.features.login.models.LoginAction
import com.brafik.famous.features.login.models.LoginEvent
import com.brafik.famous.features.login.models.LoginViewState

class LoginViewModel: BaseViewModel<LoginViewState, LoginAction, LoginEvent>(LoginViewState()) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        TODO("Not yet implemented")
    }
}