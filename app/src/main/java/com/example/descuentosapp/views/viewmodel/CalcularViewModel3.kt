package com.example.descuentosapp.views.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.descuentosapp.models.CalcularState
import kotlin.math.round

class CalcularViewModel3 : ViewModel() {

    var state by mutableStateOf(CalcularState())
        private set

    fun onValuePrecio(value: String) {
        state =
            state.copy(precio = value) //manera correcta para que la view detecte el cambio del modelo de datos si no no funciona
    }

    fun onValueDescuento(value: String) {
        state = state.copy(descuento = value)
    }


    fun calcular() {

        val precio = state.precio
        val descuento = state.descuento


        if (precio.isEmpty() || descuento.isEmpty()) {
            state = state.copy(showAlert = true)
        } else {
            val precioDescuento =
                calcularPrecio(precio = precio.toDouble(), descuento = descuento.toDouble())
            val totalDescuento =
                calcularDescuento(precio = precio.toDouble(), descuento = descuento.toDouble())

            state = state.copy(precioDescuento = precioDescuento, totalDescuento = totalDescuento)
        }
    }

    private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val res = precio - calcularDescuento(precio = precio, descuento = descuento)
        return round(res * 100) / 100.0
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val res = precio * (1 - descuento / 100)
        return round(res * 100) / 100.0
    }

    fun limpiar() {
        state = state.copy(
            precio = "",
            descuento = "",
            precioDescuento = 0.0,
            totalDescuento = 0.0
        )
    }

    fun cancelAlert() {
        state = state.copy(showAlert = false)
    }
}