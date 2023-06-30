package com.sitaram.composedesign.features.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.sitaram.composedesign.features.database.sqlite.SQLiterDBHelper

class LoginModel {

    fun loginDetails(userName: String, userPassword: String, context: Context,): Boolean {
        val databaseHelper = SQLiterDBHelper(context)
        val isSuccess = databaseHelper.getLoginUsers(userName, userPassword)
        return if (isSuccess == true) {
            Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(context, "Enter the valid details!", Toast.LENGTH_SHORT).show()
            false
        }
    }
}