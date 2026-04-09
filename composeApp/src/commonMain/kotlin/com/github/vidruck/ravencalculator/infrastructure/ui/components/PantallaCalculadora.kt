package com.github.vidruck.ravencalculator.infrastructure.ui.components
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.vidruck.ravencalculator.infrastructure.ui.theme.RavenCyan
import com.github.vidruck.ravencalculator.infrastructure.ui.viewmodel.RavenViewModel
/**
 * Pantalla principal para la calculadora en los modos Básico y Científica
 */
@Composable
fun PantallaCalculadora(viewModel: RavenViewModel) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth().weight(0.3f),
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(4.dp)
        ) {
            Box(contentAlignment = Alignment.BottomEnd, modifier = Modifier.padding(16.dp)) {
                Text(
                    text = viewModel.textoPantalla,
                    style = MaterialTheme.typography.displayMedium,
                    color = RavenCyan,
                    maxLines = 2
                )
            }
        }

        val botones = listOf(
            listOf("C", "DEL", "sin", "/"),
            listOf("7", "8", "9", "*"),
            listOf("4", "5", "6", "-"),
            listOf("1", "2", "3", "+"),
            listOf("0", ".", "PI", "=")
        )

        Column(modifier = Modifier.weight(0.7f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            botones.forEach { fila ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    fila.forEach { etiqueta ->
                        BotonRaven(
                            texto = etiqueta,
                            onClick = {
                                when (etiqueta) {
                                    "=" -> viewModel.calcularResultadoAritmetico()
                                    "C" -> viewModel.limpiarPantalla()
                                    "DEL" -> viewModel.eliminarUltimo()
                                    else -> viewModel.añadirCaracter(etiqueta)
                                }
                            },
                            modifier = Modifier.weight(1f),
                            esOperacion = etiqueta in listOf("/", "*", "-", "+", "=", "C", "DEL", "sin", "PI")
                        )
                    }
                }
            }
        }
    }
}