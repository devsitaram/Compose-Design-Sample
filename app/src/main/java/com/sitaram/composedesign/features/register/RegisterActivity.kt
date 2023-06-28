package com.sitaram.composedesign.features.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.sitaram.composedesign.R
import com.sitaram.composedesign.features.database.room.DatabaseHelper
import com.sitaram.composedesign.features.database.sqlite.RoomDBHelper

class RegisterActivity : AppCompatActivity() {
    var databaseHelper: RoomDBHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        databaseHelper = RoomDBHelper(this)
        setContent {
            ViewOfSignUPScreen(databaseHelper)
        }
    }
}