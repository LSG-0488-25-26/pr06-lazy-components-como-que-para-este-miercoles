package com.example.apicultura.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UmaDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray) // Placeholder imagen
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Nombre del personaje")
        Text("Rareza: ???")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Descripción del personaje...")
    }
}
