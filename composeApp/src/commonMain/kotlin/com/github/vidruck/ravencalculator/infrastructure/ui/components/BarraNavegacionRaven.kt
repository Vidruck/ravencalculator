package com.github.vidruck.ravencalculator.infrastructure.ui.components
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import  androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.github.vidruck.ravencalculator.domain.model.ModoCalculadora
import com.github.vidruck.ravencalculator.infrastructure.ui.theme.RavenCyan
import kotlin.math.tan

@Composable
fun BarraNavegacionRaven (modoActual : ModoCalculadora, onModoCambiado: (ModoCalculadora) -> Unit){
    val indiceSeleccionado = if (modoActual is ModoCalculadora.Geometrica) 1 else 0
    TabRow(
        selectedTabIndex = indiceSeleccionado,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = RavenCyan,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[indiceSeleccionado]),
                color = RavenCyan)
        }
    ){
        Tab(
            selected = indiceSeleccionado == 0,
            onClick = { onModoCambiado(ModoCalculadora.Basico) },
            text = {Text("Estándar / Científica")},
            selectedContentColor = RavenCyan,
            unselectedContentColor = Color.Gray
        )
        Tab(
            selected = indiceSeleccionado == 1,
            onClick = { onModoCambiado(ModoCalculadora.Geometrica) },
            text = { Text("Geometrica") },
            selectedContentColor = RavenCyan,
            unselectedContentColor = Color.Gray
        )
    }
}