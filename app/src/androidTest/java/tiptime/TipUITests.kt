package tiptime

import android.icu.text.NumberFormat
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import br.com.codelabcompose.TipTimeScreen
import br.com.codelabcompose.ui.theme.CodeLabComposeTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            CodeLabComposeTheme {
                TipTimeScreen()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Cost of Service").performTextInput("20")
        val expectedTip = "2.0"//NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: 2.0").assertExists(
            "No node with this text was found."
        )
    }
}