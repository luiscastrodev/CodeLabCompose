package br.com.codelabcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JetPackComposeTutorial(
    title: String,
    subtitle: String,
    message: String,
    modifier: Modifier = Modifier
) {

    val background = painterResource(id = R.drawable.bg_compose_background)

    Column(modifier = modifier.fillMaxWidth()) {

        Image(
            modifier = Modifier.height(100.dp),
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        )
        Text(
            text = subtitle,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(text = message,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}