package com.sitaram.composedesign

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sitaram.composedesign.login.LoginActivity
import com.sitaram.composedesign.register.ViewOfSignUPScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
//        setContent {
//            ViewOfSignUPScreen()
//            ComposeDesignTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
    }
}


//
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