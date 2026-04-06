package com.github.vidruck.ravencalculator.infrastructure.ui.viewmodel
import  androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.github.vidruck.ravencalculator.application.usecase.EvaluarExpresionUseCase
import com.github.vidruck.ravencalculator.domain.model.ModoCalculadora
import com.github.vidruck.ravencalculator.domain.service.CalculadorCientifico

/**
 *Gestiona el estado de la interfaz de usuario (UI State)
 * Actúa como puente entre la lógica de aplicación y los adaptadores de vista.
 */
class RavenViewModel {
    private val servicioCientifico = CalculadorCientifico()
    private val evaluarUseCase = EvaluarExpresionUseCase(servicioCientifico)

    var modoActual by mutableStateOf<ModoCalculadora>(ModoCalculadora.Basico)
        private set

    var textoPantalla by mutableStateOf("")
        private set

    fun cambiarModo(nuevoModo: ModoCalculadora) {
        modoActual = nuevoModo
        limpiarPantalla()
    }

    fun añadirCaracter(caracter: String) {
        textoPantalla += caracter
    }

    fun eliminarUltimo() {
        if (textoPantalla.isNotEmpty()) {
            textoPantalla = textoPantalla.dropLast(1)
        }
    }

    fun limpiarPantalla() {
        textoPantalla = ""
    }

    fun calcularResultado() {
        val resultado = evaluarUseCase.ejecutar(textoPantalla)
        textoPantalla = if (resultado.isNaN()) "Error" else resultado.toString()
    }
}