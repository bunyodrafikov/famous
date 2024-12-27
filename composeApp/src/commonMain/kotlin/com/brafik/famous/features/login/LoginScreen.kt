package com.brafik.famous.features.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.brafik.famous.features.login.models.LoginAction
import com.brafik.famous.navigation.AppScreens
import com.brafik.famous.navigation.LocalNavHost

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel { LoginViewModel() }) {
    val externalNavHost = LocalNavHost.current
    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(null)

    LoginView(viewState) { event ->
        viewModel.obtainEvent(event)
    }

    when (viewAction) {
        LoginAction.OpenMainScreen -> {
            externalNavHost.navigate(AppScreens.Main.title)
            viewModel.clearAction()
        }
        else -> { }
    }
}