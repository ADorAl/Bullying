package com.example.bullying.ui.screen.quest

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bullying.ui.component.QuestItem
import com.example.bullying.ui.component.TopBar

data class QuestUiModel(
    val id: Int,
    val title: String,
    val interval: Int,
    val message: String
)

@Composable
fun QuestListScreen(
    onBack: () -> Unit,
    onAdd: () -> Unit,
    onEdit: (QuestUiModel) -> Unit
) {

    var isDeleteMode by remember { mutableStateOf(false) }

    var questList by remember {
        mutableStateOf(
            listOf<QuestUiModel>()
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {

        TopBar(
            onBack = onBack,
            onAdd = onAdd,
            onToggleDelete = { isDeleteMode = !isDeleteMode },
            isDeleteMode = isDeleteMode
        )

        if (questList.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("퀘스트 없음")
            }
        } else {
            LazyColumn {
                items(questList, key = { it.id }) { quest ->

                    QuestItem(
                        quest = quest,
                        isDeleteMode = isDeleteMode,
                        onDelete = {
                            questList = questList.filter { it.id != quest.id }
                        },
                        onClick = {
                            onEdit(quest)
                        }
                    )
                }
            }
        }
    }
}