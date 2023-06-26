package com.sitaram.composedesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.sitaram.composedesign.main.Plant
import com.sitaram.composedesign.main.ViewOfHomePage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val plants = mutableListOf<Plant>()
        plants.add(Plant("Aloe Vera", R.string.aloe_vera, R.mipmap.img_leave))
        plants.add(Plant("Rose", R.string.rose, R.mipmap.img_leave))
        plants.add(Plant("Calendula", R.string.calendula, R.mipmap.img_leave))
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                ViewOfHomePage(plants)
            }
        }
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