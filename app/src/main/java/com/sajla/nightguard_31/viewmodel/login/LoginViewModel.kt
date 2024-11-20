package com.sajla.nightguard_31.viewmodel.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sajla.nightguard_31.data.models.LoginState

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun onValue(value: String, type: String) {
        when (type) {
            "username" -> {
                state = state.copy(username = value)
            }

            "password" -> {
                state = state.copy(password = value)
            }
        }
    }


    fun onValue(value: Boolean, type: String) {
        when (type) {
            "isUsernameCorrect" -> {
                state = state.copy(isUsernameCorrect = value)
            }

            "isPasswordCorrect" -> {
                state = state.copy(isPasswordCorrect = value)

            }

            "isCredentialsCorrect" -> {
                state = state.copy(isCredentialsCorrect = value)
            }
        }
    }
}