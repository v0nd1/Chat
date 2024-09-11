package com.vondi.chat.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.vondi.chat.ui.common.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MangoScaffold(
    topBar: @Composable () -> Unit,
    color: Color = Background,
    content: @Composable (PaddingValues) -> Unit
){
    Scaffold(
        topBar = { topBar() },
        containerColor = color,
        content = content
    )
}