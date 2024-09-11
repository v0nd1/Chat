package com.vondi.chat.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.vondi.chat.R
import com.vondi.chat.domain.model.AuthState
import com.vondi.chat.ui.common.Dimens
import com.vondi.chat.ui.common.Size
import com.vondi.chat.ui.components.MangoButton
import com.vondi.chat.ui.components.MangoFieldNumber
import com.vondi.chat.ui.components.MangoSurface
import com.vondi.chat.ui.navigation.Screen
import com.vondi.chat.ui.viewmodels.AuthViewModel

@Composable
fun AuthScreen(
    navController: NavController,
    state: AuthState,
    authViewModel: AuthViewModel
) {

    LaunchedEffect(state.isAuthSend) {
        if (state.isAuthSend){
            navController.navigate(Screen.CheckCode.route)
        }
    }

    MangoSurface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.Medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.weight(3f))
            Column(
                modifier = Modifier.weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = stringResource(R.string.chat_icon),
                    modifier = Modifier.size(Size.Big)
                )
            }

            Column(
                modifier = Modifier.weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                MangoFieldNumber(
                    placeholder = stringResource(R.string.write_phone),
                    onCountry = {
                        navController.navigate(Screen.CountryChoose.route)
                    },
                    country = state.country,
                    onEvent = authViewModel::onEvent
                )
                Spacer(modifier = Modifier.height(Dimens.Medium))
                MangoButton(
                    onClick = {
                        if (state.number.isNotEmpty()) {
                            authViewModel.sendAuthCode(state.number)
                        }

                    },
                    text = stringResource(R.string.sign_in),
                    isEnabled = state.isNumberFull
                )
            }

            Spacer(modifier = Modifier.weight(5f))


        }

    }


}