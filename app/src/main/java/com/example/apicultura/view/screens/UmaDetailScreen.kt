import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.apicultura.model.CharacterDetail
import com.example.apicultura.R
import com.example.apicultura.viewmodel.UmaViewModel
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UmaDetailScreen(
    viewModel: UmaViewModel,
    characterId: Int,
    onBack: () -> Unit
) {
    // Load character detail when this screen appears
    LaunchedEffect(characterId) {
        viewModel.loadCharacterDetail(characterId)
    }

    val character by remember { derivedStateOf { viewModel.selectedCharacter } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(character?.name_en ?: "Loading...") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        if (character == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            CharacterDetailContent(character!!, paddingValues)
        }
    }
}

@Composable
fun CharacterDetailContent(character: CharacterDetail, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        // Character image (local drawable)
        val imageId = try {
            val field = R.drawable::class.java.getField(character.name_en_internal)
            field.getInt(null)
        } catch (e: Exception) {
            R.drawable.uma_placeholder
        }

        Image(
            painter = painterResource(id = imageId),
            contentDescription = character.name_en,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = character.name_en, style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = character.profile ?: "No description available.")

        Spacer(modifier = Modifier.height(12.dp))

        if (character.birth_month != null && character.birth_day != null) {
            Text(text = "Birthday: ${character.birth_month}/${character.birth_day}")
        }
    }
}
