package com.sitaram.composedesign.features.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import com.sitaram.composedesign.R
import com.sitaram.composedesign.features.database.sqlite.RoomDBHelper

class LoginActivity : AppCompatActivity() {

    private var databaseHelper: RoomDBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        databaseHelper = RoomDBHelper(this)
        setContent {
            ViewOfLoginScreen(databaseHelper)
        }
    }
}