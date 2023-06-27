package com.sitaram.composedesign.features.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.compose.setContent
import com.sitaram.composedesign.R
import com.sitaram.composedesign.features.database.DatabaseHelper

class RegisterActivity : AppCompatActivity() {
    var databaseHelper: DatabaseHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        databaseHelper = databaseHelper?.getDatabaseInstance(this)
        setContent {
            ViewOfSignUPScreen(databaseHelper)
        }
    }
}