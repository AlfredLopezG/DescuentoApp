package com.example.descuentosapp.views.viewmodel

import com.example.descuentosapp.models.CalcularState
import org.junit.Assert.assertEquals
import org.junit.Test

class CalcularViewModel3Test{

    private val viewModel3 = CalcularViewModel3()

    @Test
    fun calcular_precio_y_descuento_validos() {

        val calcularStateExpected = CalcularState("100", "10", precioDescuento = 10.0, totalDescuento = 90.0, false)

        val currentPrecio = "100"
        val currentDescuento = "10"

        viewModel3.onValuePrecio(currentPrecio)
        viewModel3.onValueDescuento(currentDescuento)

        viewModel3.calcular()

        assertEquals(calcularStateExpected.precio, viewModel3.state.precio)
        assertEquals(calcularStateExpected.descuento, viewModel3.state.descuento)
        assertEquals(calcularStateExpected.showAlert, viewModel3.state.showAlert)
        assert(calcularStateExpected.precioDescuento == viewModel3.state.precioDescuento)
        assert(calcularStateExpected.totalDescuento == viewModel3.state.totalDescuento)
    }


    @Test
    fun calcular_precio_y_descuento_empty(){

        val calcularStateExpected = CalcularState("", "", precioDescuento = 0.0, totalDescuento = 0.0, true)

        val currentPrecio = ""
        val currentDescuento = ""

        viewModel3.onValuePrecio(currentPrecio)
        viewModel3.onValueDescuento(currentDescuento)

        viewModel3.calcular()

        assertEquals(calcularStateExpected.precio, viewModel3.state.precio)
        assertEquals(calcularStateExpected.descuento, viewModel3.state.descuento)
        assertEquals(calcularStateExpected.showAlert, viewModel3.state.showAlert)
        assert(calcularStateExpected.precioDescuento == viewModel3.state.precioDescuento)
        assert(calcularStateExpected.totalDescuento == viewModel3.state.totalDescuento)
    }


    @Test
    fun calcular_precio_empty(){

        val calcularStateExpected = CalcularState("", "10", precioDescuento = 0.0, totalDescuento = 0.0, true)

        val currentPrecio = ""
        val currentDescuento = "10"

        viewModel3.onValuePrecio(currentPrecio)
        viewModel3.onValueDescuento(currentDescuento)

        viewModel3.calcular()

        assertEquals(calcularStateExpected.precio, viewModel3.state.precio)
        assertEquals(calcularStateExpected.descuento, viewModel3.state.descuento)
        assertEquals(calcularStateExpected.showAlert, viewModel3.state.showAlert)
        assert(calcularStateExpected.precioDescuento == viewModel3.state.precioDescuento)
        assert(calcularStateExpected.totalDescuento == viewModel3.state.totalDescuento)
    }


    @Test
    fun calcular_descuento_empty(){

        val calcularStateExpected = CalcularState("100", "", precioDescuento = 0.0, totalDescuento = 0.0, true)

        val currentPrecio = "100"
        val currentDescuento = ""

        viewModel3.onValuePrecio(currentPrecio)
        viewModel3.onValueDescuento(currentDescuento)

        viewModel3.calcular()

        assertEquals(calcularStateExpected.precio, viewModel3.state.precio)
        assertEquals(calcularStateExpected.descuento, viewModel3.state.descuento)
        assertEquals(calcularStateExpected.showAlert, viewModel3.state.showAlert)
        assert(calcularStateExpected.precioDescuento == viewModel3.state.precioDescuento)
        assert(calcularStateExpected.totalDescuento == viewModel3.state.totalDescuento)
    }

    @Test
    fun limpiar_success(){

        val calcularStateExpected = CalcularState("", "", precioDescuento = 0.0, totalDescuento = 0.0, false)

        val currentPrecio = "100"
        val currentDescuento = "10"

        viewModel3.onValuePrecio(currentPrecio)
        viewModel3.onValueDescuento(currentDescuento)

        viewModel3.calcular()
        viewModel3.limpiar()

        assertEquals(calcularStateExpected.precio, viewModel3.state.precio)
        assertEquals(calcularStateExpected.descuento, viewModel3.state.descuento)
        assertEquals(calcularStateExpected.showAlert, viewModel3.state.showAlert)
        assert(calcularStateExpected.precioDescuento == viewModel3.state.precioDescuento)
        assert(calcularStateExpected.totalDescuento == viewModel3.state.totalDescuento)
    }

    @Test
    fun cancelAlert_precio_descuento_empty_success(){

        val calcularStateExpected = CalcularState("", "", precioDescuento = 0.0, totalDescuento = 0.0, false)

        val currentPrecio = ""
        val currentDescuento = ""

        viewModel3.onValuePrecio(currentPrecio)
        viewModel3.onValueDescuento(currentDescuento)

        viewModel3.calcular()

        //Primero validamos que se muestre correctamente
        assertEquals(true, viewModel3.state.showAlert)

        viewModel3.cancelAlert()

        //Despues validamos que limpie el valor correctamente
        assertEquals(calcularStateExpected.precio, viewModel3.state.precio)
        assertEquals(calcularStateExpected.descuento, viewModel3.state.descuento)
        assertEquals(calcularStateExpected.showAlert, viewModel3.state.showAlert)
        assert(calcularStateExpected.precioDescuento == viewModel3.state.precioDescuento)
        assert(calcularStateExpected.totalDescuento == viewModel3.state.totalDescuento)
    }
}