package com.example.apicultura.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apicultura.viewmodel.UmaViewModel
import com.example.apicultura.view.screens.UmaDetailScreen
import com.example.apicultura.view.screens.UmaListScreen

// NavGraph de la app.
@Composable
fun NavGraph(
    viewModel: UmaViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
            UmaListScreen(viewModel = viewModel)
        }
        composable("detail") {
            UmaDetailScreen()
        }
    }
}
