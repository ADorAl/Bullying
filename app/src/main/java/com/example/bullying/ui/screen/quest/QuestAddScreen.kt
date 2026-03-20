package com.example.bullying.ui.screen.quest

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuestAddScreen(
    onSave: (QuestUiModel) -> Unit,
    onBack: () -> Unit
) {

    var title by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var interval by remember { mutableStateOf(3) }

    // 모든 값 입력 여부
    val isValid = title.isNotBlank() && message.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("퀘스트 추가", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // 이름 입력
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("퀘스트 이름") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 시간 선택 (간단 버전)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("간격: ${interval}시간")

            Row {
                Button(onClick = { if (interval > 1) interval-- }) {
                    Text("-")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { interval++ }) {
                    Text("+")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 알림 문구 입력
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("알림 문구") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        // 추가 버튼
        Button(
            onClick = {
                val quest = QuestUiModel(
                    id = System.currentTimeMillis().toInt(),
                    title = title,
                    interval = interval,
                    message = message
                )
                onSave(quest)
            },
            enabled = isValid,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isValid) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
            )
        ) {
            Text("추가")
        }
    }
}