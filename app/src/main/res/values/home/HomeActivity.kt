package values.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.sitaram.composedesign.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val plants = mutableListOf<Plant>()
        plants.add(Plant(1,"Aloe Vera", R.string.aloe_vera, R.drawable.ic_profile))
        plants.add(Plant(2,"Rose",R.string.rose, R.drawable.ic_profile))
        plants.add(Plant(3,"Calendula",R.string.calendula, R.drawable.ic_profile))
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                ViewOfHomePage(plants)
            }
        }
    }
}
