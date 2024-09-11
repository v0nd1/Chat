package com.vondi.chat.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.vondi.chat.R
import com.vondi.chat.domain.event.AuthEvent
import com.vondi.chat.ui.common.Dimens
import com.vondi.chat.ui.common.FontSize
import com.vondi.chat.ui.common.Primary
import com.vondi.chat.ui.common.Secondary
import com.vondi.chat.ui.common.Tertiary
import com.vondi.chat.ui.components.MangoButton
import com.vondi.chat.ui.components.MangoSurface
import com.vondi.chat.ui.components.MangoTextField
import com.vondi.chat.ui.navigation.Screen
import com.vondi.chat.ui.theme.Roboto
import com.vondi.chat.ui.viewmodels.AuthViewModel

@Composable
fun RegisterScreen(
    authViewModel: AuthViewModel,
    navController: NavController
) {
    val state by authViewModel.state.collectAsState()
    var name by remember {
        mutableStateOf("")
    }
    var username by remember {
        mutableStateOf("")
    }
    val length = 5

    LaunchedEffect(state.name, state.username) {
        if (state.name.isNotEmpty() && state.username.isNotEmpty() && state.username.length >= length) {
            authViewModel.onEvent(AuthEvent.RegFull)
        } else {
            authViewModel.onEvent(AuthEvent.RegNotFull)
        }
    }

    LaunchedEffect(state.isRegSuccess) {
        if (state.isRegSuccess) {
            navController.navigate(Screen.Chat.route){
                popUpTo(0){ inclusive = true }
            }
        }
    }

    MangoSurface {
        Column(
            modifier = Modifier
                .padding(horizontal = Dimens.Medium)
                .fillMaxSize()
        ) {
            Spacer(Modifier.weight(2f))
            Column(
                modifier = Modifier
                    .weight(2f)
            ) {
                Text(
                    text = stringResource(R.string.register),
                    fontSize = FontSize.Big,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    color = Primary,
                )
                Text(
                    text = stringResource(R.string.enter_reg),
                    fontSize = FontSize.Small,
                    fontFamily = Roboto,
                    textAlign = TextAlign.Start,
                    color = Tertiary,
                )
                Text(
                    text = stringResource(R.string.root_enter),
                    fontSize = FontSize.ExtraSmall,
                    fontFamily = Roboto,
                    textAlign = TextAlign.Start,
                    color = Secondary,
                    lineHeight = FontSize.Small
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MangoTextField(
                    placeholder = "",
                    value = state.number,
                    onValueChanged = {

                    }
                )
                Spacer(Modifier.height(Dimens.Small))
                MangoTextField(
                    placeholder = stringResource(R.string.enter_username),
                    value = username,
                    onValueChanged = {
                        username = it.filter { it.isUsername() }
                        authViewModel.onEvent(AuthEvent.SetUserName(username))

                    }
                )
                Spacer(Modifier.height(Dimens.Small))
                MangoTextField(
                    placeholder = stringResource(R.string.enter_name),
                    value = name,
                    onValueChanged = {
                        name = it
                        authViewModel.onEvent(AuthEvent.SetName(name))
                    }
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                MangoButton(
                    onClick = {
                        authViewModel.register(
                            phone = state.number,
                            name = state.name,
                            username = state.username
                        )
                    },
                    text = stringResource(R.string.sign_up),
                    isEnabled = state.isRegFull
                )
            }

            Spacer(Modifier.weight(3f))
        }

    }
}

private fun Char.isUsername(): Boolean {
    return (this in 'A'..'Z' || this in 'a'..'z' || this.isDigit() || this == '-' || this == '_')
}