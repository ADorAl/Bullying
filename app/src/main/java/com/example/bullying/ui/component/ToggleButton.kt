package com.example.bullying.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ToggleButton(
    isOn: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Row {
        Button(
            onClick = { onToggle(true) },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isOn) Color.Green else Color.Gray
            )
        ) {
            Text("ON")
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = { onToggle(false) },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (!isOn) Color.Red else Color.Gray
            )
        ) {
            Text("OFF")
        }
    }
}