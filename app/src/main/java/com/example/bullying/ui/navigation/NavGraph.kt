package com.example.bullying.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bullying.ui.screen.home.HomeScreen
import com.example.bullying.ui.screen.quest.QuestAddScreen
import com.example.bullying.ui.screen.quest.QuestListScreen

@Composable
fun NavGraph() {

    // 네비게이션 상태를 관리하는 컨트롤러
    val navController = rememberNavController()

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
                onBack = {
                    // 뒤로가기
                    navController.popBackStack()
                },
                onAdd = {
                    // + 버튼 → 추가 화면
                    navController.navigate("quest_add")
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
                    // TODO: 리스트에 추가 (다음 단계에서 연결)
                    navController.popBackStack()
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}