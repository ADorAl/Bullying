package com.example.bullying.ui.component

// 가로 배치를 위한 Row
import androidx.compose.foundation.layout.Row
// 빈 공간을 넣기 위한 Spacer
import androidx.compose.foundation.layout.Spacer
// 가로 길이를 지정할 때 사용하는 width
import androidx.compose.foundation.layout.width
// 머티리얼 버튼 컴포넌트
import androidx.compose.material3.Button
// 버튼 색상을 지정할 때 사용하는 ButtonDefaults
import androidx.compose.material3.ButtonDefaults
// 텍스트 표시용 컴포넌트
import androidx.compose.material3.Text
// Composable 함수 선언용
import androidx.compose.runtime.Composable
// Modifier 사용
import androidx.compose.ui.Modifier
// 버튼 색상 지정용 Color
import androidx.compose.ui.graphics.Color
// dp 단위 사용
import androidx.compose.ui.unit.dp

// ON / OFF 상태를 전환하는 토글 버튼 UI
@Composable
fun ToggleButton(
    // 현재 토글 상태
    // true면 ON 상태, false면 OFF 상태
    isOn: Boolean,

    // 버튼 클릭 시 상태를 바꾸기 위한 콜백 함수
    onToggle: (Boolean) -> Unit
) {
    // ON 버튼과 OFF 버튼을 가로로 배치
    Row {
        // ON 버튼
        Button(
            // 클릭하면 true를 전달해서 ON 상태로 변경
            onClick = { onToggle(true) },

            // 버튼 배경색 설정
            colors = ButtonDefaults.buttonColors(
                // 현재 isOn이 true이면 초록색, 아니면 회색
                containerColor = if (isOn) Color.Green else Color.Gray
            )
        ) {
            // 버튼 안에 표시될 텍스트
            Text("ON")
        }

        // ON 버튼과 OFF 버튼 사이 간격 8dp
        Spacer(modifier = Modifier.width(8.dp))

        // OFF 버튼
        Button(
            // 클릭하면 false를 전달해서 OFF 상태로 변경
            onClick = { onToggle(false) },

            // 버튼 배경색 설정
            colors = ButtonDefaults.buttonColors(
                // 현재 isOn이 false이면 빨간색, 아니면 회색
                containerColor = if (!isOn) Color.Red else Color.Gray
            )
        ) {
            // 버튼 안에 표시될 텍스트
            Text("OFF")
        }
    }
}