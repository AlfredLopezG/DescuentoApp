package com.example.descuentosapp.views.viewmodel

import org.junit.Assert.assertEquals
import org.junit.Test

class CalcularViewModel1Test{
    private val viewModel1 = CalcularViewModel1()

    @Test
    fun calcular_precio_y_descuento_validos(){
        val resultExpected = Pair(false, Pair(10.0, 90.0))
        val currentResult = viewModel1.calcular("100", "10")

        assertEquals(resultExpected.first, currentResult.first)
        assert(resultExpected.second.first == currentResult.second.first)
        assert(resultExpected.second.second == currentResult.second.second)
    }

    @Test
    fun calcular_precio_y_descuento_empty(){
        val resultExpected = Pair(true, Pair(0.0, 0.0))
        val currentResult = viewModel1.calcular("", "")

        assertEquals(resultExpected.first, currentResult.first)
        assert(resultExpected.second.first == currentResult.second.first)
        assert(resultExpected.second.second == currentResult.second.second)
    }

    @Test
    fun calcular_precio_empty(){
        val resultExpected = Pair(true, Pair(0.0, 0.0))
        val currentResult = viewModel1.calcular("", "10")

        assertEquals(resultExpected.first, currentResult.first)
        assert(resultExpected.second.first == currentResult.second.first)
        assert(resultExpected.second.second == currentResult.second.second)
    }

    @Test
    fun calcular_descuento_empty(){
        val resultExpected = Pair(true, Pair(0.0, 0.0))
        val currentResult = viewModel1.calcular("100", "")

        assertEquals(resultExpected.first, currentResult.first)
        assert(resultExpected.second.first == currentResult.second.first)
        assert(resultExpected.second.second == currentResult.second.second)
    }
}