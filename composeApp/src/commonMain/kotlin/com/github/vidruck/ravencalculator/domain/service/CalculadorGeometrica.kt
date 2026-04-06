package com.github.vidruck.ravencalculator.domain.service
import com.github.vidruck.ravencalculator.domain.model.ResultadoGeometrica
import kotlin.math.*
/**
 * Motor de cálculo geométrico
 * (Gemometry Logic Service)
 */
class CalculadorGeometrica {
    fun calcularCuadrado(lado: Double): ResultadoGeometrica =
        ResultadoGeometrica(area = lado.pow(2), perimetro = lado *4)
    fun calcularRectangulo(base : Double, altura: Double): ResultadoGeometrica =
        ResultadoGeometrica(area = base * altura, perimetro = 2 * (base + altura))
    fun calcularCirculo(radio: Double): ResultadoGeometrica =
        ResultadoGeometrica(area = PI * radio.pow(2), perimetro = radio * 2 * PI)
    fun calcularTrianguloRect(base: Double, altura: Double): ResultadoGeometrica {
        val hipotenusa = sqrt(base.pow(2) + altura.pow(2))
        return ResultadoGeometrica(
            area = (base * altura) / 2,
            perimetro = base + altura +hipotenusa
        )
    }
}