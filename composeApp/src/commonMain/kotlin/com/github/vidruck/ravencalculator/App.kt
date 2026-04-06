package com.github.vidruck.ravencalculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.vidruck.ravencalculator.domain.model.ModoCalculadora
import com.github.vidruck.ravencalculator.infrastructure.ui.viewmodel.RavenViewModel
@Composable
@Preview
fun App() {
    val viewModel = remember {RavenViewModel()
    }
    MaterialTheme{
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(modifier = Modifier.fillMaxSize()) {
                when (viewModel.modoActual) {
                    is ModoCalculadora.Basico -> {
                    }
                    is ModoCalculadora.Cientifico -> {
                    }
                    is ModoCalculadora.Geometrica -> {
                    }
                }
            }
        }
    }
}