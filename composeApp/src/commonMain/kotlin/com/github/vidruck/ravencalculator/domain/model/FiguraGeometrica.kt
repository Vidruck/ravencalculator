package com.github.vidruck.ravencalculator.domain.model
/**
 * Representa las Figuras Geometricas soportadas por el sistema.
 * (Domain Entities)
 * */
sealed class FiguraGeometrica (val nombre: String) {
    object Cuadrado : FiguraGeometrica("Cuadrado")
    object Rectangulo : FiguraGeometrica("Rectangulo")
    object Circulo : FiguraGeometrica("Circulo")
    object Triangulo : FiguraGeometrica("Triangulo")
}
/**
 * Estructura pra devolver los calculos procesados
 * */
data class ResultadoGeometrica(
    val area: Double,
    val perimetro: Double,
)