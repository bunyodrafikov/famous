package com.brafik.famous

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brafik.famous.features.create.CreatePostScreen
import com.brafik.famous.features.login.LoginScreen
import com.brafik.famous.features.paywall.PaywallScreen
import com.brafik.famous.navigation.AppScreens
import com.brafik.famous.navigation.LocalNavHost
import com.brafik.famous.navigation.main.MainScreen
import com.brafik.famous.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    FamousApp()
}


@Composable
internal fun FamousApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: AppScreens.Login.title

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController,
            startDestination = currentScreen
        ) {
            composable(route = AppScreens.Login.title) { LoginScreen() }
            composable(route = AppScreens.Main.title) { MainScreen() }
            composable(route = AppScreens.CreatePost.title) { CreatePostScreen() }
            composable(route = AppScreens.Paywall.title) { PaywallScreen() }
        }
    }
}