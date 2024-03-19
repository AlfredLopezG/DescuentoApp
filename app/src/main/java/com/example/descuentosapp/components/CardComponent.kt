package com.example.descuentosapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TwoCard(text1: String, number1: Double, text2: String, number2: Double) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MainCard(
            text = text1,
            number = number1,
            modifier = Modifier
                .padding(start = 30.dp)
                .weight(1f)
        )

        SpaceW()

        MainCard(
            text = text2,
            number = number2,
            modifier = Modifier
                .padding(end = 30.dp)
                .weight(1f)
        )
    }
}

@Composable
fun MainCard(text: String, number: Double, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = text, color = Color.Black, fontSize = 20.sp)
            Text(text = "$${number}", color = Color.Black, fontSize = 20.sp)
        }
    }
}