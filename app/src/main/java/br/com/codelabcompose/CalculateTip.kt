package br.com.codelabcompose

import android.icu.text.NumberFormat
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TipTimeScreen() {

    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, tipPercent, roundUp = roundUp)


    val focusManager = LocalFocusManager.current

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
            label = R.string.bill_amount,
            amountInput,
            onValueChange = { amountInput = it },
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberField(
            label = R.string.cost_of_service,
            tipInput,
            onValueChange = { tipInput = it },
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )
        RoundTheTipRow(roundUp, onRoundUpChanged = { roundUp = it })
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
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
) {
    TextField(value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        label = {
            Text(text = stringResource(id = label))
        }
    )
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.DarkGray
            ),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
        )
    }
}

private fun calculateTip(
    amount: Double,
    tipPercent: Double = 15.0,
    roundUp: Boolean = false
): String {
    var tip = tipPercent / 100 * amount

    if (roundUp)
        tip = kotlin.math.ceil(tip)

    return NumberFormat.getCurrencyInstance().format(tip)
}