package com.example.apicultura.view.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.apicultura.view.components.UmaItem
import com.example.apicultura.viewmodel.UmaViewModel

@Composable
fun UmaListScreen(
    viewModel: UmaViewModel
) {
    // Lista de 8 placeholders
    val placeholders = List(8) { it }

    LazyColumn {
        items(placeholders) { _ ->
            UmaItem(
                onClick = {
                    // Ir a detalles del objeto
                }
            )
        }
    }
}
