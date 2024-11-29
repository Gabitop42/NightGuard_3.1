package com.sajla.nightguard_31.services



import com.sajla.nightguard_31.data.store.StoreLogin
import kotlinx.coroutines.flow.first

class VerifyCredentials(private val storeLogin: StoreLogin, private val encryptPassword: EncryptPassword) {

    suspend fun validate(email: String, password: String): Boolean {
        val storedEmail = storeLogin.getEmail.first()
        val storedPasswordHash = storeLogin.getPasswordHash.first()

        return storedEmail == email && encryptPassword.VerifyPassword(password, storedPasswordHash)
    }
}
