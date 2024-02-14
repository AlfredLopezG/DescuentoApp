package com.example.descuentosapp.views.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.round

class CalcularViewModel2 : ViewModel() {

    //private val _precio = mutableStateOf("")
    //val precio: State<String> = _precio

    //otra forma de declarar variables y el set se fija como privado
    // para que las demas clases no puedan cambiar el valor
    var precio2 by mutableStateOf("")
        private set

    fun onValuePrecio(value: String) {
        precio2 = value
    }

    var descuento by mutableStateOf("")
        private set

    fun onValueDescuento(value: String) {
        descuento = value
    }

    var precioDescuento by mutableStateOf(0.0)
        private set

    var totalDescuento by mutableStateOf(0.0)
        private set

    var showAlert by mutableStateOf(false)
        private set

    //Ejemplo de como setear valores a los tipos de variables
    fun cal() {
        //_precio.value = "nuevo valor"
        precio2 = "nuevo valor"
    }

    fun calcular() {

        if (precio2.isEmpty() || descuento.isEmpty()) {
            showAlert = true
        } else {
            precioDescuento =
                calcularPrecio(precio = precio2.toDouble(), descuento = descuento.toDouble())
            totalDescuento =
                calcularDescuento(precio = precio2.toDouble(), descuento = descuento.toDouble())
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
        precio2 = ""
        descuento = ""
        precioDescuento = 0.0
        totalDescuento = 0.0
    }

    fun cancelAlert() {
        showAlert = false
    }
}