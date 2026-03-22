package com.example.bullying.ui.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bullying.ui.screen.home.HomeScreen
import com.example.bullying.ui.screen.quest.QuestAddScreen
import com.example.bullying.ui.screen.quest.QuestListScreen
import com.example.bullying.ui.screen.quest.QuestUiModel

@Composable
fun NavGraph() {

    // 네비게이션 상태를 관리하는 컨트롤러
    val navController = rememberNavController()

    // 퀘스트 목록 상태
    // 이 상태를 NavGraph가 들고 있고,
    // 리스트 화면과 추가 화면이 같이 사용한다.
    var questList by remember {
        mutableStateOf(listOf<QuestUiModel>())
    }

    // 전체 화면 흐름 정의
    NavHost(
        navController = navController,
        startDestination = "home" // 시작 화면
    ) {

        // -------------------------
        // 1. 홈 화면
        // -------------------------
        composable("home") {
            HomeScreen(
                onGoToQuest = {
                    // "나 괴롭히기" 버튼 클릭 시 이동
                    navController.navigate("quest")
                }
            )
        }

        // -------------------------
        // 2. 퀘스트 리스트 화면
        // -------------------------
        composable("quest") {
            QuestListScreen(
                questList = questList, // 현재 퀘스트 목록 전달
                onBack = {
                    // 뒤로가기
                    navController.popBackStack()
                },
                onAdd = {
                    // + 버튼 → 추가 화면
                    navController.navigate("quest_add")
                },
                onDelete = { quest ->
                    // 삭제 요청이 오면 현재 목록에서 해당 퀘스트 제거
                    questList = questList.filter { it.id != quest.id }
                },
                onEdit = { quest ->
                    // TODO: 수정 화면 이동 (나중에 구현)
                }
            )
        }

        // -------------------------
        // 3. 퀘스트 추가 화면 (다음 단계)
        // -------------------------
        composable("quest_add") {
            QuestAddScreen(
                onSave = { quest ->
                    // 추가 화면에서 만든 퀘스트를 목록에 추가
                    questList = questList + quest

                    // 추가 후 이전 화면(리스트)으로 복귀
                    navController.popBackStack()
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}