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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.descuentosapp.components.Alert
import com.example.descuentosapp.components.MainButton
import com.example.descuentosapp.components.MainTextField
import com.example.descuentosapp.components.SpaceH
import com.example.descuentosapp.components.TwoCard
import com.example.descuentosapp.views.viewmodel.CalcularViewModel3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView3(viewModel: CalcularViewModel3) {
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
        ContentHomeView3(it, viewModel)
    }
}

@Composable
fun ContentHomeView3(paddingValues: PaddingValues, viewModel: CalcularViewModel3) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = viewModel.state
        TwoCard(
            text1 = "Total", number1 = state.totalDescuento,
            text2 = "Descuento", number2 = state.precioDescuento
        )

        MainTextField(
            value = state.precio,
            label = "Precio",
            onChangeValue = { viewModel.onValuePrecio(it) })
        SpaceH()
        MainTextField(
            value = state.descuento,
            label = "Descuento",
            onChangeValue = { viewModel.onValueDescuento(it) })
        SpaceH(16.dp)

        MainButton(text = "Generar descuento") {
            viewModel.calcular()
        }

        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel.limpiar()
        }

        if (state.showAlert) {
            Alert(
                title = "Alerta",
                message = "Campos requeridos",
                onConfirmClick = { viewModel.cancelAlert() })
        }
    }
}
