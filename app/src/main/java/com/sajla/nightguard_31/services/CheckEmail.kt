package com.sajla.nightguard_31.services

class CheckEmail : Validation{

    override
    fun isValid(toValidate: String): Boolean {
        val emailRegex = Regex("^[A-Za-z](.*)(@)(.+)(\\.)(.+)")
        return emailRegex.matches(toValidate)
    }

}