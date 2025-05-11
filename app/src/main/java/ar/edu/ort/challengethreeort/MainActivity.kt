package ar.edu.ort.challengethreeort

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import ar.edu.ort.challengethreeort.components.QuoteCard
import ar.edu.ort.challengethreeort.core.Config
import ar.edu.ort.challengethreeort.ui.theme.ChallengeThreeORTTheme
import ar.edu.ort.challengethreeort.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //Creo ViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadQuotes()

        enableEdgeToEdge()
        setContent {
            ChallengeThreeORTTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    QuoteCard(
                        quote = viewModel.Quote.value,
                        author = viewModel.Author.value,
                        category = viewModel.Category.value,
                        modifier = Modifier.padding(innerPadding)
                    )
                    Button(onClick = { viewModel.loadQuotes() }) {
                        Text("Actualizar texto")
                    }
                }
            }
        }
    }
}