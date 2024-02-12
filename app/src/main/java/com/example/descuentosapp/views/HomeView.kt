package com.example.descuentosapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.descuentosapp.components.Alert
import com.example.descuentosapp.components.MainButton
import com.example.descuentosapp.components.MainTextField
import com.example.descuentosapp.components.SpaceH
import com.example.descuentosapp.components.TwoCard
import com.example.descuentosapp.views.viewmodel.CalcularViewModel1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: CalcularViewModel1) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "App Descuentos", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentHomeView(it, viewModel)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel: CalcularViewModel1) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableDoubleStateOf(0.0) }
        var totalDescuento by remember { mutableDoubleStateOf(0.0) }
        var showAlert by remember { mutableStateOf(false) }

        TwoCard(
            text1 = "Total", number1 = totalDescuento,
            text2 = "Descuento", number2 = precioDescuento
        )

        MainTextField(value = precio, label = "Precio", onChangeValue = { precio = it })
        SpaceH()
        MainTextField(value = descuento, label = "Descuento", onChangeValue = { descuento = it })
        SpaceH(16.dp)

        MainButton(text = "Generar descuento") {
            val result = viewModel.calcular(precio = precio, descuento = descuento)
            showAlert = result.first
            if (!showAlert) {
                precioDescuento = result.second.first
                totalDescuento = result.second.second
            }
        }

        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            precio = ""
            descuento = ""
            precioDescuento = 0.0
            totalDescuento = 0.0
        }

        if (showAlert) {
            Alert(
                title = "Alerta",
                message = "Campos requeridos",
                onConfirmClick = { showAlert = false })
        }
    }
}
