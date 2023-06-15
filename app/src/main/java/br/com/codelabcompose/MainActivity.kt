package br.com.codelabcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.codelabcompose.data.Datasource
import br.com.codelabcompose.ui.theme.CodeLabComposeTheme
import javax.sql.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeLabComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*
                    BirthdayGreetingWithImage(
                        message = stringResource(id = R.string.jetpackcompose),
                      from =stringResource(id = R.string.from_android)
                    )
                    */
                    /*JetPackComposeTutorial(
                        stringResource(R.string.jetpack_compose_tutorial),
                        stringResource(R.string.jetpack_compose_is),
                        stringResource(R.string.in_this_tutorial)
                    ) */

                    /*TaskManager(
                        title = stringResource(id = R.string.task_manager_title),
                        message = stringResource(id = R.string.task_manager_message)
                    )*/

                    //Quadrant()

                    // VisitCard()

                    // DiceRollerApp()

                    // TipTimeScreen()

                    AffirmationList(affirmationList = Datasource().loadAffirmations())

                }
            }
        }
    }
}