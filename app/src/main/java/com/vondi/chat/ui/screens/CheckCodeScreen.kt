package com.vondi.chat.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.vondi.chat.R
import com.vondi.chat.ui.common.Dimens
import com.vondi.chat.ui.common.FontSize
import com.vondi.chat.ui.common.Primary
import com.vondi.chat.ui.common.Tertiary
import com.vondi.chat.ui.components.CodeField
import com.vondi.chat.ui.components.MangoButton
import com.vondi.chat.ui.components.MangoSurface
import com.vondi.chat.ui.navigation.Screen
import com.vondi.chat.ui.theme.Roboto
import com.vondi.chat.ui.viewmodels.AuthViewModel

@Composable
fun CheckCodeScreen(
    authViewModel: AuthViewModel,
    navController: NavController
) {
    val state by authViewModel.state.collectAsState()
    LaunchedEffect(state.isCorrectCode) {
        if (state.isCorrectCode){
            if (state.isUserExist) {
                navController.navigate(Screen.Chat.route) {
                    popUpTo(0) { inclusive = true }
                }
            } else {
                navController.popBackStack()
                navController.navigate(Screen.Register.route) {
                    popUpTo(0) { inclusive = true }
                }
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
                    text = stringResource(R.string.enter_code),
                    fontSize = FontSize.Big,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    color = Primary,
                )
                Text(
                    text = stringResource(R.string.send_code_on) + state.number,
                    fontSize = FontSize.Small,
                    fontFamily = Roboto,
                    textAlign = TextAlign.Start,
                    color = Tertiary,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CodeField(
                    onEvent = authViewModel::onEvent
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                MangoButton(
                    onClick = {
                        authViewModel.checkAuthCode(
                            phone = state.number,
                            code = state.code
                        )
                    },
                    text = stringResource(R.string.sign_in),
                    isEnabled = state.isCodeFull
                )
            }

            Spacer(Modifier.weight(5f))
        }

    }
}