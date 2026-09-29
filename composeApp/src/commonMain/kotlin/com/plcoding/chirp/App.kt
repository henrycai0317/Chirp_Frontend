package com.plcoding.chirp

import androidx.compose.runtime.Composable
import com.plcoding.auth.presentation.register.RegisterRoot
import com.plcoding.core.designsystem.theme.ChirpTheme

@Composable
fun App() {
    ChirpTheme {
        RegisterRoot()
    }
}
