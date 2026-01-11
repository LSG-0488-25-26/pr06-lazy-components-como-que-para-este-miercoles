package com.example.apicultura.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UmaItem(
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .height(80.dp)
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.Gray) // Placeholder de imagen
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                Text("Nombre del personaje")  // Placeholder
                Text("Rareza: ???")           // Placeholder
            }
        }
    }
}
