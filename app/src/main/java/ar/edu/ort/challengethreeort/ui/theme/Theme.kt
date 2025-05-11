package ar.edu.ort.challengethreeort.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    background = Color(0xFF000000)
)

@Composable
fun ChallengeThreeORTTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
      colorScheme = LightColors,
      typography = Typography,
      content = content
    )
}