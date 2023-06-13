package br.com.codelabcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun Quadrant(modifier: Modifier = Modifier) {

    Column(modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            QuadrantInfo(
                stringResource(id = R.string.first_title),
                stringResource(id = R.string.first_description),
                Modifier.weight(1f),
                Color.Yellow
            )
            QuadrantInfo(
                stringResource(id = R.string.second_title),
                stringResource(id = R.string.second_description),
                Modifier.weight(1f),
                Color.Green
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantInfo(
                stringResource(id = R.string.third_title),
                stringResource(id = R.string.third_description),
                Modifier.weight(1f),
                Color.LightGray
            )
            QuadrantInfo(
                stringResource(id = R.string.fourth_title),
                stringResource(id = R.string.fourth_description),
                Modifier.weight(1f),
                Color.Cyan
            )
        }
    }
}

@Composable
fun QuadrantInfo(
    title: String,
    message: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Green
) {
    Column(
        modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = message,
            textAlign = TextAlign.Justify
        )
    }
}