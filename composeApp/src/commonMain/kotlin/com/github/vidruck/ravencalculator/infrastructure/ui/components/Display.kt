package com.github.vidruck.ravencalculator.infrastructure.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.vidruck.ravencalculator.infrastructure.ui.theme.RavenCyan

@Composable
fun PantallaRaven(texto: String) {
    Surface(
        color = MaterialTheme.colorScheme.background, // #16161E
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, RavenCyan.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth().height(120.dp).padding(8.dp)
    ) {
        Box(contentAlignment = Alignment.BottomEnd, modifier = Modifier.padding(16.dp)) {
            Text(
                text = texto,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary, // Cian original
                maxLines = 1
            )
        }
    }
}