package com.vondi.chat.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.vondi.chat.R
import com.vondi.chat.domain.event.AuthEvent
import com.vondi.chat.ui.common.Dimens
import com.vondi.chat.ui.common.FontSize
import com.vondi.chat.ui.common.TextColor
import com.vondi.chat.ui.components.CountryButton
import com.vondi.chat.ui.components.MangoScaffold
import com.vondi.chat.ui.navigation.Screen
import com.vondi.chat.ui.theme.Roboto
import com.vondi.chat.ui.util.CountryNumber
import com.vondi.chat.ui.viewmodels.AuthViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryScreen(
    navController: NavController,
    onEvent: (AuthEvent) -> Unit,
    countries: List<CountryNumber>
) {
    MangoScaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.choose_country),
                    fontFamily = Roboto,
                    fontSize = FontSize.Medium,
                    color = TextColor
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Screen.Auth.route)
                    },
                ){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_icon_button),
                        modifier = Modifier.padding(start = Dimens.Small)
                    )
                }
            }
        )
    }) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = Dimens.Medium)
        ) {
            items(countries) { country ->
                CountryButton(
                    onClick = {
                        onEvent(AuthEvent.ChooseCountry(country))
                        navController.popBackStack()
                        navController.navigate(Screen.Auth.route)
                    },
                    country = country
                )
                Spacer(modifier = Modifier.height(Dimens.Small))
            }
        }
    }
}