package com.sajla.nightguard_31

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.sajla.nightguard_31.navigation.NavManager
import com.sajla.nightguard_31.viewmodel.login.LoginViewModel
import com.sajla.nightguard_31.views.login.LoginView

import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Instancia del LoginViewModel
            val loginViewModel = LoginViewModel()

            // Llamada a NavManager
            NavManager(loginViewModel = loginViewModel, context = LocalContext.current)
        }
    }
}
