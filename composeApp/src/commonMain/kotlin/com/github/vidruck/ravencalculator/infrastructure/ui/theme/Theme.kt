package com.github.vidruck.ravencalculator.infrastructure.ui.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = RavenCyanDark,
    background = DarkBackground,
    surface = DarkSurface,
    onPrimary = Color.White,
    onBackground = DarkText,
    onSurface = DarkText,
)
private val LightColorScheme = darkColorScheme(
    primary = RavenCyanDark,
    background = LightBackground,
    surface = LightSurface,
    onPrimary = Color.White,
    onBackground = LightText,
    onSurface = LightText,
)
@Composable
fun RavenTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
){
    var colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}