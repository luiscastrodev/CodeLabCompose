package br.com.codelabcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.codelabcompose.model.Topic

@Composable
fun TopicList(
    topics: List<Topic>,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
        )
        {
        itemsIndexed(topics) { index, topic ->

            Row(horizontalArrangement = Arrangement.Start) {
                Image(
                    modifier = Modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    painter = painterResource(id = topic.imageRes),
                    contentDescription = topic.name.toString(),
                    contentScale = ContentScale.Crop
                )
                Column() {
                    Text(
                        text = stringResource(id = topic.name),
                        Modifier.padding(bottom = 8.dp, top = 16.dp, start = 16.dp, end = 16.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp
                    )

                    Text(
                        text = index.toString(),
                        Modifier.padding(bottom = 8.dp, top = 8.dp, start = 16.dp),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}