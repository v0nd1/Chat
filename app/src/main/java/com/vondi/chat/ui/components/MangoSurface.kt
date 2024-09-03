package com.vondi.chat.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vondi.chat.ui.common.Background

@Composable
fun MangoSurface(
    modifier: Modifier = Modifier,
    color: Color = Background,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = color
    ) {
        content()
    }
}