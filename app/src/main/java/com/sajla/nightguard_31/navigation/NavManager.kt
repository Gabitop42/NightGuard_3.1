package com.sajla.nightguard_31.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sajla.nightguard_31.viewmodel.login.LoginViewModel
import com.sajla.nightguard_31.views.login.LoginView
import com.sajla.nightguard_31.views.main.MainView

@Composable
fun NavManager (viewModel: LoginViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login") {
        composable("Login") {
            LoginView(navController, viewModel)
        }
        composable("Home") {
            MainView(navController)
        }
    }
}