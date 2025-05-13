package ar.edu.ort.challengethreeort.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    background = Color(0xFFFFFFFF),          // Fondo general claro
    primary = Color(0xFF000000),            // Texto de la Quote
    onSurface = Color(0xFF424141),          // Texto del autor
    onSecondary = Color(0xFF636262),        // Texto de la categoría
    tertiary = Color(0xFFDEC23C)
)

private val DarkColors = darkColorScheme(
    background = Color(0xFF000000),          // Fondo general oscuro
    primary = Color(0xFFFFFFFF),            // Texto de la Quote
    onSurface = Color(0xFF818082),          // Texto del autor
    onSecondary = Color(0xFF88898B),
)

@Composable
fun ChallengeThreeORTTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    MaterialTheme(
      colorScheme = colors,
      typography = Typography,
      content = content
    )
}