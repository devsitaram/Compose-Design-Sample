package com.sitaram.composedesign

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.sitaram.composedesign.home.SplashScreen
import com.sitaram.composedesign.login.LoginActivity
import com.sitaram.composedesign.main.MainScreen
import com.sitaram.composedesign.main.Plant

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                SplashScreen()
            }
        }
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
//        val platList = mutableListOf<Plant>()
//        platList.add(Plant("Aloe Vera", R.string.aloe_vera, R.mipmap.img_leave))
//        platList.add(Plant("Rose", R.string.rose, R.mipmap.img_rose))
//        platList.add(Plant("Calendula", R.string.calendula, R.mipmap.img_aloevera))
//        platList.add(Plant("Aloe Vera", R.string.aloe_vera, R.mipmap.img_leave))
//        platList.add(Plant("Rose", R.string.rose, R.mipmap.img_rose))
//        platList.add(Plant("Calendula", R.string.calendula, R.mipmap.img_aloevera))
//        platList.add(Plant("Aloe Vera", R.string.aloe_vera, R.mipmap.img_leave))
//        platList.add(Plant("Rose", R.string.rose, R.mipmap.img_rose))
//        platList.add(Plant("Calendula", R.string.calendula, R.mipmap.img_aloevera))
//        setContent {
//            Surface(color = MaterialTheme.colorScheme.background) {
//                MainScreen(platList)
//            }
//        }
    }
}



//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//

// display the UI screen
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeDesignTheme {
//    }
//}