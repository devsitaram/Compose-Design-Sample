package com.sitaram.composedesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.sitaram.composedesign.features.game.GameViewModel
import com.sitaram.composedesign.features.main.NavigationAppHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen() // splash screen
        setContent {
            val navController = rememberNavController()
            NavigationAppHost(navController)
        }

    }
}