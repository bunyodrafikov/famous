package com.brafik.famous.features.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brafik.famous.components.FTextField
import com.brafik.famous.features.login.models.LoginEvent
import com.brafik.famous.features.login.models.LoginViewState
import com.brafik.famous.theme.AppTheme
import com.brafik.famous.theme.FamousTheme
import famous.composeapp.generated.resources.*
import famous.composeapp.generated.resources.Res
import famous.composeapp.generated.resources.login_intro
import famous.composeapp.generated.resources.login_title
import famous.composeapp.generated.resources.welcome_back
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun LoginView(
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {
    Column(
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            Modifier.fillMaxWidth().height(73.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(Res.string.login_title),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(Res.string.welcome_back),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(Res.string.login_intro),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }

        FTextField(viewState.email, stringResource(Res.string.login_email)) {
            eventHandler(LoginEvent.EmailChanged(it))
        }

        FTextField(viewState.password, stringResource(Res.string.login_password)) {
            eventHandler(LoginEvent.PasswordChanged(it))
        }

        Row {
            TextButton(onClick = {}) {
                Text(
                    stringResource(Res.string.login_forgot_password),
                    color = FamousTheme.colors.primaryText
                )
            }

            Spacer(Modifier.weight(1f))

            TextButton(onClick = {}) {
                Text(
                    stringResource(Res.string.login_login),
                    color = FamousTheme.colors.primaryText
                )
            }
        }

        TextButton(onClick = {}) {
            Text(
                stringResource(Res.string.login_register),
                color = FamousTheme.colors.tintColor
            )
        }
    }
}

@Preview
@Composable
private fun LoginViewPreview() {
    AppTheme {
        LoginView(LoginViewState("bob123@gmail.com", "bob123")) {}
    }
}