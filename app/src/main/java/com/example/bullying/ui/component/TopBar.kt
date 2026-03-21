package com.example.bullying.ui.component

// Material3 UI 컴포넌트들 사용
import androidx.compose.material3.*
// Compose에서 함수형 UI를 만들기 위한 어노테이션
import androidx.compose.runtime.Composable

// ExperimentalMaterial3Api를 사용하는 TopAppBar 때문에 필요
@OptIn(ExperimentalMaterial3Api::class)
// 이 함수는 Compose UI 컴포넌트라는 의미
@Composable
fun TopBar(
    onBack: () -> Unit,          // 뒤로가기 버튼 클릭 시 실행할 함수
    onAdd: () -> Unit,           // 추가 버튼 클릭 시 실행할 함수
    onToggleDelete: () -> Unit,  // 삭제 모드 전환 버튼 클릭 시 실행할 함수
    isDeleteMode: Boolean        // 현재 삭제 모드 여부
) {
    // 상단 앱 바(TopAppBar) 생성
    TopAppBar(
        // 가운데 또는 왼쪽에 표시될 제목
        title = { Text("나를 괴롭히는 것들") },

        // 왼쪽 네비게이션 아이콘 영역
        navigationIcon = {
            // 뒤로가기 버튼
            IconButton(onClick = onBack) {
                // 현재는 아이콘 대신 텍스트 "<" 사용
                Text("<")
            }
        },

        // 오른쪽 액션 버튼들 영역
        actions = {
            // 추가 버튼
            IconButton(onClick = onAdd) {
                // 현재는 아이콘 대신 텍스트 "+" 사용
                Text("+")
            }

            // 삭제 모드 전환 버튼
            IconButton(onClick = onToggleDelete) {
                // 삭제 모드이면 "완료", 아니면 "-" 표시
                Text(if (isDeleteMode) "완료" else "-")
            }
        }
    )
}