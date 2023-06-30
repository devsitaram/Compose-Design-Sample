package com.sitaram.composedesign.features.register

import android.content.Context
import android.widget.Toast
import com.sitaram.composedesign.features.database.sqlite.SQLiterDBHelper
import com.sitaram.composedesign.features.util.Validation

class RegisterModel {

    // register function
    fun registerDetails(userEmail: String, userName: String, userPassword: String, context: Context): Boolean {
        val databaseHelper = SQLiterDBHelper(context)
        val validation = Validation()

        // initialize the variable
        val isValidEmail = validation.emailValidation(userEmail)
        val isValidName = validation.nameValidation(userName)

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
}