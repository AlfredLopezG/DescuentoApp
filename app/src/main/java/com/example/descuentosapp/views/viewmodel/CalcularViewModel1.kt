package com.example.descuentosapp.views.viewmodel

import androidx.lifecycle.ViewModel
import kotlin.math.round

class CalcularViewModel1 : ViewModel() {

    fun calcular(
        precio: String,
        descuento: String
    ): Pair<Boolean, Pair<Double, Double>> { //showalert, precioDescuento, TotalDescuento
        var precioDescuento = 0.0
        var totalDescuento = 0.0
        var showAlert = false

        if (precio.isNullOrEmpty() || descuento.isNullOrEmpty()) {
            showAlert = true
        } else {
            precioDescuento =
                calcularPrecio(precio = precio.toDouble(), descuento = descuento.toDouble())
            totalDescuento =
                calcularDescuento(precio = precio.toDouble(), descuento = descuento.toDouble())
        }

        return Pair(showAlert, Pair(precioDescuento, totalDescuento))
    }

    private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val res = precio - calcularDescuento(precio = precio, descuento = descuento)
        return round(res * 100) / 100.0
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val res = precio * (1 - descuento / 100)
        return round(res * 100) / 100.0
    }
}