package com.example.descuentosapp.views.viewmodel

import org.junit.Assert.assertEquals
import org.junit.Test

class CalcularViewModel2Test {
    private val viewModel2 = CalcularViewModel2()

    @Test
    fun calcular_precio_y_descuento_validos() {

        val currentPrecio = "100"
        val currentDescuento = "10"
        val showAlertExpected = false
        val precioDescuentoExpected = 10.0
        val totalDescuentoExpected = 90.0

        viewModel2.onValuePrecio(currentPrecio)
        viewModel2.onValueDescuento(currentDescuento)

        viewModel2.calcular()

        assertEquals(currentPrecio, "100")
        assertEquals(currentDescuento, "10")
        assertEquals(showAlertExpected, viewModel2.showAlert)
        assert(precioDescuentoExpected == viewModel2.precioDescuento)
        assert(totalDescuentoExpected == viewModel2.totalDescuento)
    }

    @Test
    fun calcular_precio_y_descuento_empty(){

        val currentPrecio = ""
        val currentDescuento = ""
        val showAlertExpected = true
        val precioDescuentoExpected = 0.0
        val totalDescuentoExpected = 0.0

        viewModel2.onValuePrecio(currentPrecio)
        viewModel2.onValueDescuento(currentDescuento)

        viewModel2.calcular()

        assertEquals(currentPrecio, "")
        assertEquals(currentDescuento, "")
        assertEquals(showAlertExpected, viewModel2.showAlert)
        assert(precioDescuentoExpected == viewModel2.precioDescuento)
        assert(totalDescuentoExpected == viewModel2.totalDescuento)
    }

    @Test
    fun calcular_precio_empty(){

        val currentPrecio = ""
        val currentDescuento = "10"
        val showAlertExpected = true
        val precioDescuentoExpected = 0.0
        val totalDescuentoExpected = 0.0

        viewModel2.onValuePrecio(currentPrecio)
        viewModel2.onValueDescuento(currentDescuento)

        viewModel2.calcular()

        assertEquals(currentPrecio, "")
        assertEquals(currentDescuento, "10")
        assertEquals(showAlertExpected, viewModel2.showAlert)
        assert(precioDescuentoExpected == viewModel2.precioDescuento)
        assert(totalDescuentoExpected == viewModel2.totalDescuento)
    }

    @Test
    fun calcular_descuento_empty(){

        val currentPrecio = "100"
        val currentDescuento = ""
        val showAlertExpected = true
        val precioDescuentoExpected = 0.0
        val totalDescuentoExpected = 0.0

        viewModel2.onValuePrecio(currentPrecio)
        viewModel2.onValueDescuento(currentDescuento)

        viewModel2.calcular()

        assertEquals(currentPrecio, "100")
        assertEquals(currentDescuento, "")
        assertEquals(showAlertExpected, viewModel2.showAlert)
        assert(precioDescuentoExpected == viewModel2.precioDescuento)
        assert(totalDescuentoExpected == viewModel2.totalDescuento)
    }

    @Test
    fun limpiar_success(){

        val currentPrecio = "100"
        val currentDescuento = "10"
        val precioExpected = ""
        val descuentoExpected = ""
        val precioDescuentoExpected = 0.0
        val totalDescuentoExpected = 0.0

        viewModel2.onValuePrecio(currentPrecio)
        viewModel2.onValueDescuento(currentDescuento)

        viewModel2.calcular()
        viewModel2.limpiar()

        assertEquals(precioExpected, viewModel2.precio2)
        assertEquals(descuentoExpected, viewModel2.descuento)
        assert(precioDescuentoExpected == viewModel2.precioDescuento)
        assert(totalDescuentoExpected == viewModel2.totalDescuento)
    }

    @Test
    fun cancelAlert_precio_descuento_empty_success(){

        val currentPrecio = ""
        val currentDescuento = ""
        val showAlertExpected = false

        viewModel2.onValuePrecio(currentPrecio)
        viewModel2.onValueDescuento(currentDescuento)

        viewModel2.calcular()

        //Primero validamos que se muestre correctamente
        assertEquals(true, viewModel2.showAlert)

        viewModel2.cancelAlert()

        //Despues validamos que limpie el valor correctamente
        assertEquals(showAlertExpected, viewModel2.showAlert)
    }

}