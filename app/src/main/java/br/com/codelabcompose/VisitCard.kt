package br.com.codelabcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview
fun VisitCard(
    name: String = "Luis Ricardo",
    job: String = "Android Developer Extraordinaire",
    phone: String = "+11(123) 444 444",
    hashTag: String = "@AndroidDev",
    email: String = "@android.com",
    modifier: Modifier = Modifier
): Unit {

    Column(
        modifier
            .fillMaxSize()
            .background(Color.Black).padding(8.dp)
    ) {

        Column(
            Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier.size(width = 120.dp, height = 120.dp)
            )
            Text(
                text = name,
                fontSize = 36.sp,
                color = Color.White
            )
            Text(
                text = job,
                fontWeight = FontWeight.SemiBold,
                color = Color.Green
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_local_phone_24),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = Color.Green)

                )
                Text(
                    text = phone,
                    color = Color.LightGray,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_share_24),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = Color.Green)
                )
                Text(
                    text = hashTag,
                    color = Color.LightGray,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = Color.Green)
                )
                Text(
                    text = email,
                    color = Color.LightGray,
                    modifier = Modifier.padding(start = 16.dp)

                )
            }
        }

    }

}


