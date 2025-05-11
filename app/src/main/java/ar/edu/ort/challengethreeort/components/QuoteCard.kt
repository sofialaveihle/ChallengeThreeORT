package ar.edu.ort.challengethreeort.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun QuoteCardPreview() {
    QuoteCard(
        quote = "May the Force be with you",
        author = "George Lucas",
        category = "movies"
    )
}

@Composable
fun QuoteCard(
    quote: String,
    author: String,
    category: String
) {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = quote,
            style = TextStyle(
                color = Color.Blue
            )
        )
        Text(
            text = author,
            style = TextStyle(
            color = Color.Blue
            )
        )
        Text(
            text = category,
            style = TextStyle(
            color = Color.Blue
            )
        )

    }
}