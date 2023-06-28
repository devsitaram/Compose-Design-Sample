package com.sitaram.composedesign.features.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.sitaram.composedesign.R
import com.sitaram.composedesign.features.home.pojo.FlowerPojo

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                ViewOfHomePage()
            }
        }
    }
}



