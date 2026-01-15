import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.apicultura.viewmodel.UmaViewModel
import com.example.apicultura.view.components.UmaItem

@Composable
fun UmaListScreen(viewModel: UmaViewModel, navController: NavController) {
    LazyColumn {
        items(viewModel.characterList) { character ->
            UmaItem(character = character) {
                navController.navigate("detail/${character.id}")
            }
        }
    }
}
