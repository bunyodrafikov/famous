package com.brafik.famous.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*

internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
internal fun AppTheme(
    content: @Composable () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember(systemIsDark) { mutableStateOf(systemIsDark) }
    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalFamousColors provides darkPalette,
        content = content
    )
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
