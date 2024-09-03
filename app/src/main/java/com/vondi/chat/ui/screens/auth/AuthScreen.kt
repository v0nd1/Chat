package com.vondi.chat.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.vondi.chat.R
import com.vondi.chat.ui.common.Dimens
import com.vondi.chat.ui.common.Size
import com.vondi.chat.ui.components.MangoButton
import com.vondi.chat.ui.components.MangoFieldNumber
import com.vondi.chat.ui.components.MangoSurface

@Composable
fun AuthScreen(
    navController: NavController
) {
    MangoSurface {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.Medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Column(
//                modifier = Modifier.weight(3f),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    text = "Введите ваш номер телефона для регистрации или входа",
//                    fontFamily = Roboto,
//                    fontSize = FontSize.Medium,
//                    textAlign = TextAlign.Center,
//                    color = TextColor,
//                    lineHeight = FontSize.Big
//                )
//            }

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
                    placeholder = stringResource(R.string.write_phone)
                )
                Spacer(modifier = Modifier.height(Dimens.Medium))
                MangoButton(
                    onClick = { /*TODO*/ },
                    text = stringResource(R.string.sign_in)
                )
            }

            Spacer(modifier = Modifier.weight(5f))


        }

    }


}