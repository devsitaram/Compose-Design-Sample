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

@Composable
fun ViewOfHomePage(platList: List<FlowerPojo>) {

}

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

// recycler
@Composable
fun Recycler() {
    var number by remember { mutableStateOf(0) }
    val context = LocalContext.current
    var inputNum by remember { mutableStateOf("") }

    val isNumberValid by remember(inputNum) {
        derivedStateOf {
            inputNum.isNotEmpty()
        }
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // input text
                InputEditTextField(
                    inputNum,
                    onValueChange = { inputNum = it },
                    text = "Enter a number"
                )
                ButtonWithBorder(
                    onClickAction = {
                        if (isNumberValid) {
                            number = inputNum.toInt()
                        } else {
                            CoroutineScope(Dispatchers.Main).launch {
                                Toast.makeText(context, "The field is empty!", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
                )
            }
            var i = 1
            if (number == 0) {
                Greeting("Hello", number)
            }
            while (i <= number) {
                Greeting("Hello", i)
                i++
            }
        }
    }
}

@Composable
fun Greeting(name: String, i: Int) {
    var expanded by remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 5.dp else 0.dp
    )
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "$i")
                Text(text = name)
            }
            ElevatedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun ButtonWithBorder(onClickAction: () -> Unit) {
    Button(
        modifier = Modifier.padding(5.dp),
        onClick = onClickAction,
        border = BorderStroke(1.dp, Color.Gray),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
    ) {
        Text(text = "Click", color = Color.DarkGray)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputEditTextField(value: String, onValueChange: (String) -> Unit = {}, text: String) {
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .width(250.dp)
                .height(70.dp)
                .padding(top = 5.dp),
            label = { Text(text) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedLabelColor = Purple,
                cursorColor = Purple
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        // if the fields is empty then show error message
        if (value.isEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "The fields is empty!", color = Color.Red)
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