package com.sitaram.composedesign.features.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.sitaram.composedesign.R
import com.sitaram.composedesign.features.home.pojo.PlantPojo

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        setContent {
//            MainScreenView()
//        }
        val platList = mutableListOf<PlantPojo>()
        platList.add(PlantPojo("Aloe Vera", R.string.aloe_vera, R.mipmap.img_aloevera))
        platList.add(PlantPojo("Rose", R.string.rose, R.mipmap.img_rose))
        platList.add(PlantPojo("Calendula", R.string.calendula, R.mipmap.img_calendula))
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                ViewOfHomePage(platList)
            }
        }
    }
}



