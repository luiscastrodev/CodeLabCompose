package br.com.codelabcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

@Composable
fun BirthdayGreetingWithImage(
    message: String, from: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier.fillMaxSize()) {

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}
