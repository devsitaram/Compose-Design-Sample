package com.sitaram.composedesign.features.register

import android.content.Context
import android.widget.Toast
import com.sitaram.composedesign.features.database.sqlite.SQLiterDBHelper

class RegisterModel {

    // register function
    fun registerDetails(userEmail: String, userName: String, userPassword: String, context: Context): Boolean {
        val databaseHelper = SQLiterDBHelper(context)

        // initialize the variable
        val isValidEmail = emailValidation(userEmail)
        val isValidName = nameValidation(userName)

        return if (isValidEmail && isValidName) {
            // call the register button click method
            val isRegisterSuccess = databaseHelper.registerUser(userEmail, userName, userPassword)
            return if (isRegisterSuccess == true) {
                Toast.makeText(context, "Register Success.", Toast.LENGTH_SHORT).show()
                true
            } else {
                Toast.makeText(context, "Please enter the valid data!", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(context, "Enter the valid details!", Toast.LENGTH_SHORT).show()
            false
        }
    }

    // check the username validation
    private fun emailValidation(email: String): Boolean {
        // get text fields text
        val emailPattern = Regex("[a-zA-Z\\d._-]+@[a-z]+.+[a-z]+")
        return email.matches(emailPattern)
    }

    // check the username validation
    private fun nameValidation(username: String): Boolean {
        val nameRegex = Regex("[A-Za-z\\s]+")
        return username.matches(nameRegex)
    }

    // check the username validation
    private fun passwordValidation(password: String): Boolean {
        val nameRegex = Regex("[a-zA-Z0-9]")
        return password.matches(nameRegex)
    }
}