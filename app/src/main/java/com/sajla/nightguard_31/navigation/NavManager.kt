package com.sajla.nightguard_31.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sajla.nightguard_31.views.register.RegisterView
import com.sajla.nightguard_31.data.store.StoreLogin
import com.sajla.nightguard_31.services.EncryptPassword
import com.sajla.nightguard_31.viewmodel.login.LoginViewModel
import com.sajla.nightguard_31.viewmodel.login.RegisterViewModel
import com.sajla.nightguard_31.views.login.LoginView
import com.sajla.nightguard_31.views.main.StartView

@Composable
fun NavManager(loginViewModel: LoginViewModel, context: Context) {
    val navController = rememberNavController()


    val storeLogin = StoreLogin(context)
    val encryptPassword = EncryptPassword()

    NavHost(navController = navController, startDestination = "Login") {
        composable("Login") {
            LoginView(navController, loginViewModel)
        }
        composable("Register") {
            RegisterView(
                navController,
                viewModel = RegisterViewModel(storeLogin, encryptPassword)
            )
        }
        composable("Home") {
            StartView(navController)
        }
    }
}

