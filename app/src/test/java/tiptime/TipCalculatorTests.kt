package tiptime

import br.com.codelabcompose.calculateTip
import org.junit.Test
import java.text.NumberFormat
import org.junit.Assert.assertEquals

class TipCalculatorTests {

    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = "2.0"//NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}