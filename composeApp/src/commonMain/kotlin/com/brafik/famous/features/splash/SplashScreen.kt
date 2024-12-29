package com.brafik.famous.features.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.brafik.famous.features.splash.models.SplashAction
import com.brafik.famous.navigation.AppScreens

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel { SplashViewModel() },
    navController: NavController
) {
    val viewAction by viewModel.viewActions().collectAsState(initial = null)

    when(viewAction) {
        SplashAction.ShowMainScreen -> navController.navigate(AppScreens.Main.route)
        SplashAction.ShowLoginScreen -> navController.navigate(AppScreens.Login.route)
        else -> {}
    }
}