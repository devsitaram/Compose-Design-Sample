package com.sitaram.composedesign.features.login

import android.content.Context
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    // create the object of Login Model class
    private val loginModel = LoginModel()

    fun loginDetails(userName: String, userPassword: String, context: Context): Boolean? {
        val isSuccess = loginModel.getLoginUser(userName, userPassword, context)
        return if (isSuccess == true) {
            true
        } else {
            return false
        }
    }
}