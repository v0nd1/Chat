package com.vondi.chat.ui.components

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.vondi.chat.ui.common.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MangoScaffold(
    topBar: () -> Unit,
    color: Color = Background,
    content: @Composable () -> Unit
){
    Scaffold(
        topBar = { topBar() },
        containerColor = color
    ) {
        content()
    }
}