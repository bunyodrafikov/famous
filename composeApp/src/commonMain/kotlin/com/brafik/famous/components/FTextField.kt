package com.brafik.famous.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brafik.famous.theme.AppTheme
import com.brafik.famous.theme.FamousTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun FTextField(
    text: String,
    hint: String = "",
    enabled: Boolean = true,
    onTextChanged: (String) -> Unit
) {
    TextField(
        value = text,
        enabled = enabled,
        placeholder = { Text(hint, color = FamousTheme.colors.tintColor, fontSize = 14.sp) },
        shape = RoundedCornerShape(14.dp),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = FamousTheme.colors.secondaryBackground,
            focusedContainerColor = FamousTheme.colors.secondaryBackground,
            disabledContainerColor = FamousTheme.colors.secondaryBackground.copy(alpha = .3f),
            focusedTextColor = FamousTheme.colors.tintColor,
            unfocusedTextColor = FamousTheme.colors.tintColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        onValueChange = onTextChanged,
        textStyle = TextStyle(fontSize = 16.sp),
        modifier = Modifier.fillMaxWidth(),
    )
}

@Preview
@Composable
fun FTextFieldPreview() {
    AppTheme {
        Column(Modifier.fillMaxSize()) {
            FTextField("Some Value") {}
            FTextField("", hint = "Email", enabled = false) {}
        }
    }
}