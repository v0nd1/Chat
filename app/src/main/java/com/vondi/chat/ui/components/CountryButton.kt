package com.vondi.chat.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vondi.chat.ui.common.Dimens
import com.vondi.chat.ui.common.FontSize
import com.vondi.chat.ui.common.Primary
import com.vondi.chat.ui.common.Size
import com.vondi.chat.ui.theme.Roboto
import com.vondi.chat.ui.util.CountryNumber

@Composable
fun CountryButton(
    onClick: () -> Unit,
    country: CountryNumber
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.Medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${country.flagEmoji} ${country.country}",
                fontFamily = Roboto,
                fontSize = FontSize.Small
            )

            Text(
                text = country.code,
                fontFamily = Roboto,
                fontSize = FontSize.Small,
                color = Primary

            )
        }
    }
}