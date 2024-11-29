package com.sajla.nightguard_31.viewmodel.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajla.nightguard_31.data.models.RegisterState
import com.sajla.nightguard_31.data.store.StoreLogin
import com.sajla.nightguard_31.services.CheckEmail
import com.sajla.nightguard_31.services.CheckPassword
import com.sajla.nightguard_31.services.EncryptPassword
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val storeLogin: StoreLogin,
    private val encryptPassword: EncryptPassword
) : ViewModel() {

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

    fun registerUser(onResult: (Boolean, String?) -> Unit) {
        val emailValidator = CheckEmail()
        val passwordValidator = CheckPassword()


        if (!emailValidator.isValid(state.email)) {
            onResult(false, "Invalid email format")
            return
        }


        if (!passwordValidator.isValid(state.password)) {
            onResult(false, "Password must contain at least 8 characters, including upper/lower case, a digit, and a special character.")
            return
        }


        if (state.password != state.confirmPassword) {
            onResult(false, "Passwords do not match")
            return
        }


        val encryptedPassword = encryptPassword.HashPassword(state.password)


        viewModelScope.launch {
            storeLogin.saveEmail(state.email)
            storeLogin.savePasswordHash(encryptedPassword)
        }


        onResult(true, null)
    }
}


