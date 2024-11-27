package com.sajla.nightguard_31.viewmodel.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sajla.nightguard_31.data.models.RegisterState

class RegisterViewModel : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    fun onValue(value: String, type: String) {
        when (type) {
            "username" -> state = state.copy(username = value)
            "email" -> state = state.copy(email = value)
            "password" -> state = state.copy(password = value)
            "confirmPassword" -> state = state.copy(confirmPassword = value)
        }
    }

    fun onValue(value: Boolean, type: String) {
        when (type) {
            "isUsernameValid" -> state = state.copy(isUsernameValid = value)
            "isEmailValid" -> state = state.copy(isEmailValid = value)
            "isPasswordValid" -> state = state.copy(isPasswordValid = value)
            "isConfirmPasswordValid" -> state = state.copy(isConfirmPasswordValid = value)
            "isFormValid" -> state = state.copy(isFormValid = value)
        }
    }

    fun registerUser(onResult: (Boolean) -> Unit) {

        val isSuccess = state.password == state.confirmPassword
        onResult(isSuccess)
    }
}