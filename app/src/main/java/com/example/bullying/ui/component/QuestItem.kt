package com.example.bullying.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bullying.ui.screen.quest.QuestUiModel

@Composable
fun QuestItem(
    quest: QuestUiModel,
    isDeleteMode: Boolean,
    onDelete: () -> Unit,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = !isDeleteMode) { onClick() }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(text = quest.title)
            Text(text = "${quest.interval}시간마다")
        }

        if (isDeleteMode) {
            Button(onClick = onDelete) {
                Text("-")
            }
        } else {
            Button(onClick = onClick) {
                Text("설정")
            }
        }
    }
}