package com.example.apicultura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apicultura.ui.theme.APIculturaTheme
import com.example.apicultura.viewmodel.UmaViewModel
import com.example.apicultura.view.navigation.NavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Mantiene compatibilidad con pantalla completa

        setContent {
            APIculturaTheme {
                // Creamos el ViewModel
                val umaViewModel: UmaViewModel = viewModel()

                // Cargamos la navegación
                NavGraph(viewModel = umaViewModel)
            }
        }
    }
}
