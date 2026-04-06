package com.github.vidruck.ravencalculator

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Raven-Calculator",
    ) {
        App()
    }
}