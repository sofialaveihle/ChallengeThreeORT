package ar.edu.ort.challengethreeort.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ar.edu.ort.challengethreeort.R

@Composable
fun MyFloatingActionButton(
    isDarkTheme: Boolean,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick ,
        containerColor = if (isDarkTheme) Color.White else Color.Black,
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.arrow_circle),
            contentDescription = null,
            tint = if (isDarkTheme) Color.Black else Color.White
        )
    }
}