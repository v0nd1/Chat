package com.vondi.chat.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.vondi.chat.ui.common.FontSize
import com.vondi.chat.ui.common.Primary
import com.vondi.chat.ui.theme.Roboto

@Composable
fun MangoButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
    text: String,
) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = FontSize.Small
        )

    }
}