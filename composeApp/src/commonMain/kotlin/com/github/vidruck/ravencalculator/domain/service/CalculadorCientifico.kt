package com.github.vidruck.ravencalculator.domain.service
import kotlin.math.*
/**
 * Servicio encargado de las operaciones matemáticas avanzadas.
 * (Scientific Logic Service)
*/
class CalculadorCientifico {
    private val Gras_a_Rad = PI / 180.0
    /**
     *Ejecuta funciones trigonometicas convirtiendo grados a radianes.
     * @param valor El angulo en grados.
     */
    fun seno(valor: Double) : Double = sin(valor * Gras_a_Rad)
    fun coseno(valor: Double) : Double = cos(valor * Gras_a_Rad)
    fun tangente(valor: Double) : Double = tan(valor * Gras_a_Rad)

    /**
     * Operaciones logaritmicas y de potencia
     */
    fun logaritmoDiez(valor: Double) : Double = log10(valor)
    fun logaritmoNatural(valor: Double) : Double = ln(valor)
    fun raizCuadrada(valor: Double): Double = if (valor >= 0) sqrt(valor) else Double.NaN

    val pi: Double = PI

}