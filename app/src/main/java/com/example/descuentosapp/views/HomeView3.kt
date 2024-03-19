package com.example.descuentosapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.descuentosapp.components.SpaceH
import com.example.descuentosapp.components.SpaceW
import com.example.descuentosapp.views.viewmodel.CalcularViewModel3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView3(viewModel: CalcularViewModel3) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "App Descuentos",
                        color = Color.White,
                        modifier = Modifier.testTag("titleAppBar")
                    )
                },
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
        /*TwoCard(
            text1 = "Total", number1 = state.totalDescuento,
            text2 = "Descuento", number2 = state.precioDescuento
        )*/

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                modifier = Modifier
                    .padding(start = 30.dp)
                    .weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Total", color = Color.Black, fontSize = 20.sp)
                    Text(
                        text = "$${state.totalDescuento}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.testTag("total")
                    )
                }
            }

            SpaceW()

            Card(
                modifier = Modifier
                    .padding(start = 30.dp)
                    .weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Descuento", color = Color.Black, fontSize = 20.sp)
                    Text(
                        text = "$${state.precioDescuento}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.testTag("descuento")
                    )
                }
            }
        }

        /*MainTextField(
            value = state.precio,
            label = "Precio",
            onChangeValue = { viewModel.onValuePrecio(it) })*/

        OutlinedTextField(
            value = state.precio,
            label = { Text(text = "Precio") },
            onValueChange = { viewModel.onValuePrecio(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .testTag("fieldPrecio")
        )

        SpaceH()
        /*MainTextField(
            value = state.descuento,
            label = "Descuento",
            onChangeValue = { viewModel.onValueDescuento(it) })*/

        OutlinedTextField(
            value = state.descuento,
            label = { Text(text = "Descuento") },
            onValueChange = { viewModel.onValueDescuento(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .testTag("fieldDescuento")
        )

        SpaceH(16.dp)

        /*MainButton(text = "Generar descuento") {
            viewModel.calcular()
        }*/

        OutlinedButton(
            onClick = { viewModel.calcular() },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .testTag("btnGenerar")
        ) {
            Text(text = "Generar descuento")
        }

        SpaceH()
        /*MainButton(text = "Limpiar", color = Color.Red) {
            viewModel.limpiar()
        }*/

        OutlinedButton(
            onClick = { viewModel.limpiar() },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Red
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .testTag("btnLimpiar")
        ) {
            Text(text = "Limpiar")
        }


        if (state.showAlert) {
            /*Alert(
                title = "Alerta",
                message = "Campos requeridos",
                onConfirmClick = { viewModel.cancelAlert() })*/

            AlertDialog(
                onDismissRequest = { },
                modifier = Modifier.testTag("alertCamposVacios"),
                title = { Text(text = "Alerta") },
                text = { Text(text = "Campos requeridos") },
                confirmButton = {
                    Button(onClick = { viewModel.cancelAlert() }, modifier = Modifier.testTag("btnAcceptDialog")) {
                        Text(text = "Aceptar")
                    }
                }
            )
        }
    }
}
