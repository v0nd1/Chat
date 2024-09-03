package com.vondi.chat.ui.screens.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.vondi.chat.ui.common.Dimens
import com.vondi.chat.ui.components.CountryButton
import com.vondi.chat.ui.components.MangoScaffold
import com.vondi.chat.ui.components.MangoSurface
import com.vondi.chat.ui.util.CountryNumber


@Composable
fun CountryScreen(
    navController: NavController,
    countries: List<CountryNumber>
) {

    MangoScaffold(topBar = { /*TODO*/ }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.Medium)
        ) {
            items(countries) { country ->
                CountryButton(
                    onClick = {},
                    country = country
                )
                Spacer(modifier = Modifier.height(Dimens.Small))
            }
        }
    }
}