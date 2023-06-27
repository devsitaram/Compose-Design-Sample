package com.sitaram.composedesign.features.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.sitaram.composedesign.R
import com.sitaram.composedesign.features.database.DatabaseHelper

class LoginActivity : AppCompatActivity() {

    private var databaseHelper: DatabaseHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        databaseHelper = databaseHelper?.getDatabaseInstance(this)
        setContent {
            ViewOfLoginScreen(databaseHelper)
        }
    }
}