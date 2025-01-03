package com.brafik.famous.navigation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brafik.famous.navigation.AppScreens
import com.brafik.famous.navigation.LocalNavHost
import com.brafik.famous.theme.FamousTheme

enum class MainScreens(val route: String) {
    Home("home"), Subscriptions("subscriptions"), Post("post"), Inbox("inbox"), Library("Library");
}

@Composable
fun MainScreen() {
    val parentNavController = LocalNavHost.current
    val navController = rememberNavController()
    val items = MainScreens.entries.toTypedArray()
    val bottomNavHeight = 75.dp

    Box(Modifier.fillMaxSize()) {
        NavHost(
            navController,
            modifier = Modifier.padding(bottom = bottomNavHeight).fillMaxHeight(),
            startDestination = MainScreens.Home.route
        ) {
            composable(MainScreens.Home.route) { Text("Hello, Home", color = FamousTheme.colors.tintColor) }
            composable(MainScreens.Subscriptions.route) { Text("Hello, Subscriptions", color = FamousTheme.colors.tintColor) }
            composable(MainScreens.Post.route) { Text("Hello, Post", color = FamousTheme.colors.tintColor) }
            composable(MainScreens.Inbox.route) { Text("Hello, Inbox", color = FamousTheme.colors.tintColor) }
            composable(MainScreens.Library.route) { Text("Hello, Library", color = FamousTheme.colors.tintColor) }
        }
        BottomNavigation(
            modifier = Modifier.align(Alignment.BottomStart)
                .fillMaxWidth()
                .height(bottomNavHeight),
            backgroundColor = FamousTheme.colors.secondaryBackground
        ) {
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntry?.destination
            items.forEach { screen ->
                val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = when (screen) {
                                MainScreens.Home -> Icons.Filled.Home
                                MainScreens.Subscriptions -> Icons.Filled.Check
                                MainScreens.Post -> Icons.Filled.Add
                                MainScreens.Inbox -> Icons.Filled.MailOutline
                                MainScreens.Library -> Icons.Filled.AccountBox
                            },
                            contentDescription = screen.route,
                            tint = if(isSelected) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor
                        )
                    },
                    label = {
                        Text(
                            screen.route.capitalize(),
                            color = if(isSelected) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor
                        )
                    },
                    selected = isSelected,
                    onClick = {
                        if (screen == MainScreens.Post) {
                            parentNavController.navigate(AppScreens.CreatePost.route)
                        } else {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().displayName) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                )
            }
        }
    }
}