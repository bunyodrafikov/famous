package com.brafik.famous

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brafik.famous.features.create.CreatePostScreen
import com.brafik.famous.features.login.LoginScreen
import com.brafik.famous.features.paywall.PaywallScreen
import com.brafik.famous.features.splash.SplashScreen
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
    val currentScreen = backStackEntry?.destination?.route ?: AppScreens.Login.route

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController,
            startDestination = AppScreens.Splash.route
        ) {
            composable(route = AppScreens.Splash.route) {
                SplashScreen(navController = navController)
            }
            composable(route = AppScreens.Login.route) { LoginScreen() }
            composable(route = AppScreens.Main.route) { MainScreen() }
            composable(route = AppScreens.CreatePost.route) { CreatePostScreen() }
            composable(route = AppScreens.Paywall.route) { PaywallScreen() }
        }
    }
}