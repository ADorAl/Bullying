package com.example.bullying.ui.screen.quest

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bullying.ui.component.QuestItem
import com.example.bullying.ui.component.TopBar

// 퀘스트 목록 화면
@Composable
fun QuestListScreen(
    questList: List<QuestUiModel>, // 현재 퀘스트 목록
    onBack: () -> Unit,
    onAdd: () -> Unit,
    onDelete: (QuestUiModel) -> Unit, // 삭제 요청을 바깥으로 전달
    onEdit: (QuestUiModel) -> Unit
) {

    // 삭제 모드 여부를 저장하는 상태
    // true면 삭제 버튼/삭제 UI가 보이도록 사용
    var isDeleteMode by remember { mutableStateOf(false) }

    // 화면 전체를 세로로 배치
    Column(modifier = Modifier.fillMaxSize()) {

        // 상단 바 영역
        TopBar(
            onBack = onBack,                             // 뒤로가기 버튼 동작
            onAdd = onAdd,                               // 추가 버튼 동작
            onToggleDelete = { isDeleteMode = !isDeleteMode }, // 삭제 모드 ON/OFF 전환
            isDeleteMode = isDeleteMode                  // 현재 삭제 모드 상태 전달
        )

        // 퀘스트가 하나도 없을 때
        if (questList.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                // 중앙에 안내 문구 표시
                Text("퀘스트 없음")
            }
        } else {
            // 퀘스트가 있을 때 리스트로 표시
            LazyColumn {
                // questList를 하나씩 꺼내서 QuestItem으로 보여줌
                items(questList, key = { it.id }) { quest ->

                    QuestItem(
                        quest = quest,                   // 현재 퀘스트 데이터 전달
                        isDeleteMode = isDeleteMode,     // 삭제 모드 여부 전달
                        onDelete = {
                            // 삭제 버튼 클릭 시 현재 퀘스트 삭제 요청 전달
                            onDelete(quest)
                        },
                        onClick = {
                            // 퀘스트 클릭 시 수정 화면으로 이동
                            onEdit(quest)
                        }
                    )
                }
            }
        }
    }
}