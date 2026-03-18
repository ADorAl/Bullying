package com.example.bullying.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bullying.ui.screen.home.HomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                onGoToQuest = {
                    navController.navigate("quest")
                }
            )
        }

        composable("quest") {
            Text("퀘스트 화면") // 이후 구현
        }
    }
}