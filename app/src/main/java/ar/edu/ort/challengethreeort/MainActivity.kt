package ar.edu.ort.challengethreeort

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.challengethreeort.components.QuoteCard
import ar.edu.ort.challengethreeort.ui.theme.ChallengeThreeORTTheme
import ar.edu.ort.challengethreeort.ui.theme.Peach
import ar.edu.ort.challengethreeort.ui.theme.colorGradient
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
            ChallengeThreeORTTheme {
                Box(
                    modifier = Modifier.background(Brush.horizontalGradient(colorStops = colorGradient))
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = Color.Transparent
                    ) { innerPadding ->

                        Column(
                            modifier = Modifier
                                .padding(vertical = 150.dp, horizontal = 20.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            QuoteCard(
                                quote = viewModel.Quote.value,
                                author = viewModel.Author.value,
                                category = viewModel.Category.value,
                                modifier = Modifier.padding(innerPadding)
                            )
                            IconButton(
                                onClick = { viewModel.loadQuotes() }
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.arrow_circle),
                                    contentDescription = "Circle arrow",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(
                                            color = Peach
                                        )
                                )

                            }
                        }
                    }
                }
            }
        }
    }
}