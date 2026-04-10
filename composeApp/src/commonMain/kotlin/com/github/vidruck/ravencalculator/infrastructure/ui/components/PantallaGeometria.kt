package com.github.vidruck.ravencalculator.infrastructure.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.github.vidruck.ravencalculator.domain.model.FiguraGeometrica
import com.github.vidruck.ravencalculator.infrastructure.ui.theme.RavenCyan
import com.github.vidruck.ravencalculator.infrastructure.ui.viewmodel.RavenViewModel
import org.jetbrains.compose.resources.painterResource
import raven_calculator.composeapp.generated.resources.Res
import raven_calculator.composeapp.generated.resources.circulo
import raven_calculator.composeapp.generated.resources.cuadrado
import raven_calculator.composeapp.generated.resources.rectangulo
import raven_calculator.composeapp.generated.resources.triangulo_rec

@Composable
fun PantallaGeometria(viewModel: RavenViewModel){
    var figuraSeleccionada by remember { mutableStateOf<FiguraGeometrica>(FiguraGeometrica.Cuadrado) }
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }

    val esInput1Valido = input1.toDoubleOrNull()?.let {it > 0} ?: false
    val esInput2Valido = input2.toDoubleOrNull()?.let {it > 0} ?: false

    val botonHabilitado = when (figuraSeleccionada){
        is FiguraGeometrica.Cuadrado, is FiguraGeometrica.Circulo -> esInput1Valido
        is FiguraGeometrica.Rectangulo, is FiguraGeometrica.Triangulo -> esInput1Valido && esInput2Valido
    }
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            listOf(
                FiguraGeometrica.Cuadrado, FiguraGeometrica.Rectangulo,
                FiguraGeometrica.Circulo, FiguraGeometrica.Triangulo
            ).forEach {figura ->
                BotonRaven(
                    texto = figura.nombre,
                    onClick = {
                        figuraSeleccionada = figura
                        input1 = ""; input2 = ""
                    }, modifier = Modifier.weight(1f), esOperacion = figuraSeleccionada == figura
                )
            }
        }
        OutlinedTextField(
            value = input1,
            onValueChange = { input1 = it },
            label = {Text(if(figuraSeleccionada is FiguraGeometrica.Circulo)"Radio" else if(figuraSeleccionada is FiguraGeometrica.Cuadrado)"Lado" else "Base") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = input1.isNotEmpty() && !esInput1Valido,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = RavenCyan,
                unfocusedIndicatorColor = RavenCyan
            )
        )
        if (figuraSeleccionada is FiguraGeometrica.Rectangulo || figuraSeleccionada is FiguraGeometrica.Triangulo) {
            OutlinedTextField(
                value = input2,
                onValueChange = { input2 = it },
                label = {Text("Altura")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = input2.isNotEmpty() && !esInput2Valido,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = RavenCyan,
                    unfocusedIndicatorColor = RavenCyan
                )
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth().height(150.dp).padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            val imagenRecurso = when (figuraSeleccionada) {
                FiguraGeometrica.Cuadrado -> Res.drawable.cuadrado
                FiguraGeometrica.Rectangulo -> Res.drawable.rectangulo
                FiguraGeometrica.Circulo -> Res.drawable.circulo
                FiguraGeometrica.Triangulo -> Res.drawable.triangulo_rec
            }

            Image(
                painter = painterResource(imagenRecurso),
                contentDescription = "Ilustración de ${figuraSeleccionada.nombre}",
                modifier = Modifier.fillMaxHeight()
            )
        }
        Button(
            onClick = {
                val datos = mutableMapOf<String, Double> ()
                if (figuraSeleccionada is FiguraGeometrica.Circulo) datos["radio"] = input1.toDouble()
                else if (figuraSeleccionada is FiguraGeometrica.Cuadrado) datos["lado"] = input1.toDouble()
                else {
                    datos["base"] = input1.toDouble()
                    datos["altura"] = input2.toDouble()
                }
                viewModel.calcularResultadoGeometrico(figuraSeleccionada, datos)
            },
            enabled = botonHabilitado,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = RavenCyan, disabledContainerColor = androidx.compose.ui.graphics.Color.DarkGray)
        ){
            Text("Calcular Área y Perímetro", color = androidx.compose.ui.graphics.Color.Black)
        }
        viewModel.resultadoGeometria?.let{resultado ->
            Card (modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)){
                Column (modifier = Modifier.padding(16.dp)){
                    Text("Resultados: ", style = MaterialTheme.typography.titleMedium, color = RavenCyan)
                    Text("Área: ${resultado.area}")
                    Text("Perímetro: ${resultado.perimetro}")
                }
            }
        }
    }
}