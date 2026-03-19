package com.example.bullying.ui.component

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onBack: () -> Unit,
    onAdd: () -> Unit,
    onToggleDelete: () -> Unit,
    isDeleteMode: Boolean
) {
    TopAppBar(
        title = { Text("나를 괴롭히는 것들") },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Text("<")
            }
        },
        actions = {
            IconButton(onClick = onAdd) {
                Text("+")
            }
            IconButton(onClick = onToggleDelete) {
                Text(if (isDeleteMode) "완료" else "-")
            }
        }
    )
}