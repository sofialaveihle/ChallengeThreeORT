package ar.edu.ort.challengethreeort

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ar.edu.ort.challengethreeort.components.MyFloatingActionButton
import ar.edu.ort.challengethreeort.components.MyTopBar
import ar.edu.ort.challengethreeort.components.QuoteCard
import ar.edu.ort.challengethreeort.ui.theme.ChallengeThreeORTTheme
import ar.edu.ort.challengethreeort.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //Creo ViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadQuotes()

        enableEdgeToEdge()
        setContent {

            val systemDarkTheme = isSystemInDarkTheme()
            var isDarkTheme by rememberSaveable { mutableStateOf(systemDarkTheme) }

            ChallengeThreeORTTheme(useDarkTheme = isDarkTheme) {
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background,
                    topBar = {
                        MyTopBar(
                            isDarkTheme,
                            onToggleTheme = { isDarkTheme = !isDarkTheme }
                        )
                    },
                    floatingActionButtonPosition = FabPosition.Center,
                    floatingActionButton = {
                        MyFloatingActionButton(
                            isDarkTheme,
                            onClick = { viewModel.loadQuotes() }
                        )
                    },
                    content = { innerPadding ->
                        QuoteCard(
                            quote = viewModel.Quote.value,
                            author = viewModel.Author.value,
                            category = viewModel.Category.value,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                )
            }
        }
    }
}