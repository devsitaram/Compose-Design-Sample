package com.sitaram.composedesign

import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.sitaram.composedesign.features.main.NavigationAppHost
import com.sitaram.composedesign.features.splash.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                SplashScreen()
            }
        }
        Handler().postDelayed({
            setContent {
                val navController = rememberNavController()
                NavigationAppHost(navController)
            }
        }, 2000)
    }
}