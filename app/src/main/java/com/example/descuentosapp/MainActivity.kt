package com.example.descuentosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.descuentosapp.ui.theme.DescuentosAppTheme
import com.example.descuentosapp.views.HomeView3
import com.example.descuentosapp.views.viewmodel.CalcularViewModel1
import com.example.descuentosapp.views.viewmodel.CalcularViewModel2
import com.example.descuentosapp.views.viewmodel.CalcularViewModel3
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CalcularViewModel1 by viewModels()
        val viewModel2: CalcularViewModel2 by viewModels()
        val viewModel3: CalcularViewModel3 by viewModels()
        setContent {
            DescuentosAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //HomeView(viewModel)
                    //HomeView2(viewModel = viewModel2)
                    HomeView3(viewModel = viewModel3)
                }
            }
        }
    }
}