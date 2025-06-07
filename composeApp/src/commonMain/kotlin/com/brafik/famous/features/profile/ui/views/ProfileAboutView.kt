package com.brafik.famous.features.profile.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import com.brafik.famous.theme.FamousTheme

@Composable
fun ProfileAboutView() {
    Text(text = "Hello, About", color = FamousTheme.colors.primaryText)
}