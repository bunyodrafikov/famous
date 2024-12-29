package com.brafik.famous.features.splash

import com.brafik.famous.base.BaseViewModel
import com.brafik.famous.features.login.domain.IsUserAuthorisedUseCase
import com.brafik.famous.features.splash.models.SplashAction

class SplashViewModel(
    private val isUserAuthorisedUseCase: IsUserAuthorisedUseCase = IsUserAuthorisedUseCase()
) : BaseViewModel<Unit, SplashAction, Unit>(Unit) {
    init {
        checkUserAuthorised()
    }

    override fun obtainEvent(viewEvent: Unit) {}

    private fun checkUserAuthorised() {
        viewAction = if (isUserAuthorisedUseCase.execute()) {
            SplashAction.ShowMainScreen
        } else {
            SplashAction.ShowLoginScreen
        }
    }
}