package com.example.bullying.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bullying.ui.component.ToggleButton

@Composable
fun HomeScreen(
    onGoToQuest: () -> Unit
) {
    var isOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ON / OFF
        ToggleButton(
            isOn = isOn,
            onToggle = { isOn = it }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // 나 괴롭히기 버튼
        Button(
            onClick = onGoToQuest,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("나 괴롭히기")
        }
    }
}