package com.github.vidruck.ravencalculator.infrastructure.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculadoraGrid(onInput: (String) -> Unit, onCalculate: () -> Unit, onClear: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BotonRaven("sin", { onInput("sin(") }, Modifier.weight(1f))
            BotonRaven("cos", { onInput("cos(") }, Modifier.weight(1f))
            BotonRaven("sqrt", { onInput("sqrt(") }, Modifier.weight(1f))
            BotonRaven("DEL", { /* lógica backspace */ }, Modifier.weight(1f), esOperacion = true)
        }

        // Bloque Numérico Estándar
        val filas = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("0", ".", "=", "+")
        )

        filas.forEach { fila ->
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                fila.forEach { char ->
                    BotonRaven(
                        texto = char,
                        onClick = { if (char == "=") onCalculate() else onInput(char) },
                        modifier = Modifier.weight(1f),
                        esOperacion = char in listOf("/", "*", "-", "+", "=")
                    )
                }
            }
        }
    }
}