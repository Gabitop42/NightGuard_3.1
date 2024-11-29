package com.sajla.nightguard_31.services

class CheckPassword : Validation {

    override
    fun isValid(toValidate: String): Boolean {
        val lenghtValid = toValidate.length >= 8
        val upperCaseValid = toValidate.any { it.isUpperCase() }
        val lowerCaseValid = toValidate.any { it.isLowerCase() }
        val digitValid = toValidate.any { it.isDigit() }
        val specialCharValid = toValidate.any { !it.isLetterOrDigit() }

        return lenghtValid && upperCaseValid && lowerCaseValid && digitValid && specialCharValid

    }

}