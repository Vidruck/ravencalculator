package com.github.vidruck.ravencalculator.application.usecase

import com.github.vidruck.ravencalculator.domain.service.CalculadorCientifico
import kotlin.math.*

/**
 * Analizador Sintáctico de grado de ingeniería para expresiones matemáticas.
 * Implementa un algoritmo de Descenso Recursivo.
 */
class EvaluarExpresionUseCase(private val servicio: CalculadorCientifico) {
    private var pos = -1
    private var ch = 0
    /**
     *  Inicia la evaluación de la cadena de texto
     */
    fun ejecutar(expresion: String): Double {
        if (expresion.isEmpty()) return 0.0
        pos = -1
        val expLimpia = expresion.replace(",", "")

        return try {
            nextChar(expLimpia)
            val x = parseExpression(expLimpia)
            if (pos < expLimpia.length)throw  Exception("Invalid expresion")
            x
        } catch (e: Exception){
            Double.NaN
        }
    }
    private fun nextChar(str: String) {
        ch = if (++pos < str.length) str[pos].code else -1
    }
    private fun eat(charToEat: Int, str: String): Boolean {
        while (ch == ' '.code) nextChar(str)
        if (ch == charToEat) {
            nextChar(str)
            return true
        }
        return false
    }
    private fun parseExpression(str: String): Double {
        var x = parseTerm(str)
        while (true){
            if (eat('+'.code, str)) x += parseTerm(str)
            else if (eat('-'.code, str)) x -= parseTerm(str)
            else return x
        }
    }
    private fun parseTerm(str: String): Double {
        var x = parseFactor(str)
        while (true){
            if (eat('*'.code, str)) x *= parseFactor(str)
            else if (eat('/'.code, str)) x /= parseFactor(str)
            else return x
        }
    }
    private fun parseFactor(str: String): Double {
        if (eat('+'.code, str)) return parseFactor(str)
        if (eat('-'.code, str)) return -parseFactor(str)
        var x: Double
        val startPos = pos
        if (eat('('.code, str)) {
            x = parseExpression(str)
            eat(')'.code, str)
        }else if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) {
            while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code ) nextChar(str)
            x = str.substring(startPos, pos).toDouble()
        } else if (ch >= 'a'.code && ch <= 'z'.code || ch >= 'A'.code && ch <= 'Z'.code) { // Funciones
            while (ch >= 'a'.code && ch <= 'z'.code || ch >= 'A'.code && ch <= 'Z'.code) nextChar(str)
            val func = str.substring(startPos, pos)
            x = parseFactor(str)
            x = when (func) {
                "sin" -> servicio.seno(x)
                "cos" -> servicio.coseno(x)
                "tan" -> servicio.tangente(x)
                "log" -> servicio.logaritmoDiez(x)
                "ln" -> servicio.logaritmoNatural(x)
                "sqrt" -> servicio.raizCuadrada(x)
                else -> throw Exception("Función desconocida: $func")
            }
        } else if (str.substring(startPos).startsWith("PI")) {
            x = servicio.pi
            pos += 1
            nextChar(str)
        } else {
            throw Exception("Error de sintaxis")
        }

        if (eat('^'.code, str)) x = x.pow(parseFactor(str))
        return x
    }
}