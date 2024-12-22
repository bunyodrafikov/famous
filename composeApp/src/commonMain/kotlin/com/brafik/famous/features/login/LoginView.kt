package com.brafik.famous.features.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brafik.famous.features.login.models.LoginEvent
import com.brafik.famous.features.login.models.LoginViewState
import com.brafik.famous.theme.AppTheme
import com.brafik.famous.theme.FamousTheme
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
    Column {
        Row(
            Modifier.fillMaxWidth().height(73.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(Res.string.login_title),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
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
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun LoginViewPreview() {
    AppTheme {
        LoginView(LoginViewState("bob123@gmail.com", "bob123")) {

        }
    }
}