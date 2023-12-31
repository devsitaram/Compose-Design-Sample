package com.sitaram.composedesign.features.login

import android.content.Context
import com.sitaram.composedesign.features.database.sqlite.SQLiterDBHelper

class LoginModel {
    fun getLoginUser(userName: String, userPassword: String, context: Context): Boolean? {
        val databaseHelper = SQLiterDBHelper(context)
        return databaseHelper.getLoginUsers(userName, userPassword)
    }
}
