import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.apicultura.view.screens.*
import com.example.apicultura.viewmodel.UmaViewModel

@Composable
fun NavGraph(viewModel: UmaViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {

        composable("list") {
            UmaListScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            route = "detail/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getInt("characterId") ?: 0
            UmaDetailScreen(
                viewModel = viewModel,
                characterId = characterId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
