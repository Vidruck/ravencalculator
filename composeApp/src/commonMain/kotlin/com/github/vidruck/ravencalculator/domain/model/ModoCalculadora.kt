package com.github.vidruck.ravencalculator.domain.model
/**
 * Representa los modos de operacion disponibles en la calculadora
 * Usamos la clase sellada (Sealed Class) para asegurar el control estricto de tipos.
 * */
sealed class ModoCalculadora {
    object Basico: ModoCalculadora()
    object Cientifico: ModoCalculadora()
    object Geometrica: ModoCalculadora()
}