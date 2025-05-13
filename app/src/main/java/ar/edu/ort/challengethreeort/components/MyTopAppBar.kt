package ar.edu.ort.challengethreeort.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.challengethreeort.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Transparent,
        ),
        title = {
            Text("")
        },
        actions = {
            IconButton(onClick = onToggleTheme) {
                Icon(
                    painter = painterResource(
                        id = if (isDarkTheme) R.drawable.light_mode else R.drawable.dark_mode
                    ),
                    contentDescription = "Cambiar tema",
                    modifier = Modifier.size(24.dp),
                    tint = if (isDarkTheme) Color.White else Color.Black
                )
            }
        }
    )
}