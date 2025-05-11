package ar.edu.ort.challengethreeort.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.challengethreeort.R
import ar.edu.ort.challengethreeort.ui.theme.Brown
import ar.edu.ort.challengethreeort.ui.theme.DarkBrown

@Composable
fun QuoteCard(
    quote: String,
    author: String,
    category: String,
    modifier: Modifier
) {
    val contentList = listOf(quote, author, category)

    LazyColumn(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(color = Brown)
            .border(
                shape = RoundedCornerShape(20.dp),
                color = DarkBrown,
                width = 4.dp
            ),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(16.dp),

    ) {
        contentList.forEach { textItem ->
            item {
                Box(
                    modifier = Modifier
                        .width(350.dp)
                ) {
                    Text(
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.patua_one_regular)),
                            color = DarkBrown,
                            fontSize = 20.sp
                        ),
                        text = textItem,
                    )
                }


            }
        }
    }
}