package br.com.codelabcompose

import android.icu.text.NumberFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TipTimeScreen() {
    var amountInput by remember {
        mutableStateOf("")
    }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)

    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {

        Text(
            text = stringResource(id = R.string.calculate_tip),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.align(alignment = CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberField(
            amountInput,
            onValueChange = {amountInput = it}
        )

        Text(
            text = stringResource(id = R.string.tip_amount, tip),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(
    value: String,
    onValueChange: (String) -> Unit
){
    TextField(value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        label = {
            Text(text = stringResource(id = R.string.cost_of_service))
        }
    )
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}