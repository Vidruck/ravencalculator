package com.github.vidruck.ravencalculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.github.vidruck.ravencalculator.domain.model.ModoCalculadora
import com.github.vidruck.ravencalculator.infrastructure.ui.components.BarraNavegacionRaven
import com.github.vidruck.ravencalculator.infrastructure.ui.components.PantallaCalculadora
import  com.github.vidruck.ravencalculator.infrastructure.ui.components.PantallaGeometria
import com.github.vidruck.ravencalculator.infrastructure.ui.theme.RavenTheme
import com.github.vidruck.ravencalculator.infrastructure.ui.viewmodel.RavenViewModel
@Composable
fun App() {
    val viewModel = remember { RavenViewModel() }

    RavenTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                BarraNavegacionRaven(
                    modoActual = viewModel.modoActual,
                    onModoCambiado = { viewModel.cambiarModo(it) }
                )
                when (viewModel.modoActual) {
                    is ModoCalculadora.Basico, is ModoCalculadora.Cientifico -> {
                        PantallaCalculadora(viewModel)
                    }
                    is ModoCalculadora.Geometrica -> {
                        PantallaGeometria(viewModel)
                    }
                }
            }
        }
    }
}