package com.github.vidruck.ravencalculator.infrastructure.ui.components
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.vidruck.ravencalculator.infrastructure.ui.theme.*
/**
 * Botón personalizado conforme a la identidad visual
 */
@Composable
fun BotonRaven(
    texto: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    esOperacion: Boolean = false
){
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if(esOperacion) RavenCyan else MaterialTheme.colorScheme.surfaceVariant,
            contentColor = if (esOperacion) Color.Black else MaterialTheme.colorScheme.onSurface
        ),
        border = BorderStroke(1.dp, RavenCyan),
        contentPadding = PaddingValues(12.dp)
    ){
        Text(text = texto, style = MaterialTheme.typography.bodyLarge)
    }
}
