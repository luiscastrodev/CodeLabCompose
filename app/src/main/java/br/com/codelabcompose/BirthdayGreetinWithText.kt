package br.com.codelabcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BirthdayGreetingWithText(
    message: String, from: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()
    , verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp, end = 16.dp).align(Alignment.End),

        )
    }
}
