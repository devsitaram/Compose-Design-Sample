package values.home

import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sitaram.composedesign.features.home.pojo.FlowerPojo
import com.sitaram.composedesign.ui.theme.Purple
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview
@Composable
fun Home() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(15.dp)
    ) {
        Column(modifier = Modifier
            .padding(1.dp)
            .background(Color.Black)
            .verticalScroll(rememberScrollState())) {

        }
    }
}

// button navigation bar
@Composable
fun ListItem(name: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Course")
                    Text(
                        text = name,
                        style = TextStyle(
                            fontWeight = FontWeight.ExtraBold,
                            fontStyle = FontStyle.Normal
                        )
                    )
                }

                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Show more")
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home")
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Profile")
        }
    }
}

@Composable
fun AccountScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Account")
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Settings")
        }
    }
}


//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainScreen() {
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = { BottomNavigationBar() }
//    ) {
//        Navigation(navController)
//    }
//
//}
//
//@Composable
//fun BottomNavigationBar() {
//    val items = listOf(
//        NavigationItem.Home,
//        NavigationItem.Profile,
//        NavigationItem.Notification,
//        NavigationItem.Settings
//    )
//    BottomNavigation()
//}
//
//        bottomBar = {
//            BottomNavigation(
//                backgroundColor = MaterialTheme.colorScheme.background
//            ) {
//                val navBackStackEntry by navController.currentBackStackEntryAsState()
//                val currentRoute = navBackStackEntry?.destination?.route
//
//                items.forEach { item ->
//                    BottomNavigationItem (
//                        selected = currentRoute == item.route,
//                        onClick = {
//                            if (currentRoute != item.route) {
//                                navController.popBackStack(navController.graph.startDestinationId, false)
//                                navController.navigate(item.route)
//                            }
//                        },
//                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
//                        label = { Text(text = item.label) },
//                        selectedContentColor = Color.DarkGray,
//                        unselectedContentColor = Color.LightGray
//                    )
//                }
//            }
//        }
//    ) {
//        NavigationButton(navController = navController)
//    }
//}
//
//@Composable
//fun NavigationButton(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
//
//        composable(NavigationItem.Home.route) {
//            HomeScreen()
//        }
//
//        composable(NavigationItem.Profile.route) {
//            ProfileScreen()
//        }
//
//        composable(NavigationItem.Notification.route) {
//            AccountScreen()
//        }
//
//        composable(NavigationItem.Settings.route) {
//            SettingsScreen()
//        }
//    }
//}