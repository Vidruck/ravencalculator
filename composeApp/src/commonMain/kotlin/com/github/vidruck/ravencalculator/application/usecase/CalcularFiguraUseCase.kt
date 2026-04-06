package com.github.vidruck.ravencalculator.application.usecase
import com.github.vidruck.ravencalculator.domain.model.*
import com.github.vidruck.ravencalculator.domain.service.CalculadorGeometrica
/**
 * Orquestador para ejecutar el cálculo según la figura seleccionada
 */
class CalcularFiguraUseCase (private val calculador: CalculadorGeometrica) {
    fun ejecutar(figura: FiguraGeometrica, datos: Map<String, Double>): ResultadoGeometrica {
        return when (figura){
            FiguraGeometrica.Cuadrado -> calculador.calcularCuadrado(datos["lado"]?:0.0)
            FiguraGeometrica.Rectangulo -> calculador.calcularRectangulo(datos["base"] ?: 0.0, datos["altura"] ?: 0.0)
            FiguraGeometrica.Circulo -> calculador.calcularCirculo(datos["radio"] ?: 0.0)
            FiguraGeometrica.Triangulo -> calculador.calcularTrianguloRect(datos["base"] ?: 0.0, datos["altura"] ?: 0.0)
        }
    }
}