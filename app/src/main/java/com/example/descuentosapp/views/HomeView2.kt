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
import com.example.descuentosapp.views.viewmodel.CalcularViewModel2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView2(viewModel: CalcularViewModel2) {
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
        ContentHomeView2(it, viewModel)
    }
}

@Composable
fun ContentHomeView2(paddingValues: PaddingValues, viewModel: CalcularViewModel2) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TwoCard(
            text1 = "Total", number1 = viewModel.totalDescuento,
            text2 = "Descuento", number2 = viewModel.precioDescuento
        )

        MainTextField(
            value = viewModel.precio2,
            label = "Precio",
            onChangeValue = { viewModel.onValuePrecio(it) })
        SpaceH()
        MainTextField(
            value = viewModel.descuento,
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

        if (viewModel.showAlert) {
            Alert(
                title = "Alerta",
                message = "Campos requeridos",
                onConfirmClick = { viewModel.cancelAlert() })
        }
    }
}
