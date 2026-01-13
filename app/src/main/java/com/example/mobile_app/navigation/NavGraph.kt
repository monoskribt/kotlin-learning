package com.example.mobile_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobile_app.dao.UserDao
import com.example.mobile_app.screen.HomeScreen
import com.example.mobile_app.screen.LoginScreen
import com.example.mobile_app.screen.RegisterScreen

@Composable
fun NavGraph(navController: NavHostController, dao: UserDao) {
    NavHost(navController, startDestination = "register") {

        composable("register") {
            RegisterScreen(navController, dao)
        }

        composable("login") {
            LoginScreen(navController, dao)
        }

        composable("home/{login}") { backStackEntry ->
            val login = backStackEntry.arguments?.getString("login") ?: ""
            HomeScreen(navController, login)
        }
    }
}