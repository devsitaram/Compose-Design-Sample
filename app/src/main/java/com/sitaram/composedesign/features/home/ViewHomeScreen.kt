package com.sitaram.composedesign.features.home

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sitaram.composedesign.R
import com.sitaram.composedesign.features.home.pojo.FlowerPojo
import com.sitaram.composedesign.ui.theme.Purple
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview
@Composable
fun ViewOfHomePage() {

    val context = LocalContext.current

    var number by remember { mutableIntStateOf(0) }
    var inputNum by remember { mutableStateOf("") }

    val isNumberValid by remember(inputNum) {
        derivedStateOf {
            inputNum.isNotEmpty()
        }
    }

    val flowerList = mutableListOf<FlowerPojo>()
    flowerList.add(FlowerPojo("Aloe Vera", R.string.aloe_vera, R.mipmap.img_aloevera))
    flowerList.add(FlowerPojo("Rose", R.string.rose, R.mipmap.img_rose))
    flowerList.add(FlowerPojo("Calendula", R.string.calendula, R.mipmap.img_calendula))
    flowerList.add(FlowerPojo("Erigeron", R.string.erigeron, R.mipmap.img_erigeron))
    flowerList.add(FlowerPojo("Rhododendron", R.string.rhododendron, R.mipmap.img_rhododerndorn))
    flowerList.add(FlowerPojo("Bluebell", R.string.bluebell, R.mipmap.img_bluebell))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.padding(bottom = 10.dp),
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
                        try {
                            number = inputNum.toInt()
                            Toast.makeText(context, "$number times show", Toast.LENGTH_SHORT)
                                .show()
                        } catch (_: NumberFormatException) {
                            Toast.makeText(
                                context,
                                "Enter the valid number!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        CoroutineScope(Dispatchers.Main).launch {
                            Toast.makeText(context, "The field is empty!", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
        ) {
            items(flowerList) { plant ->
                PlantCard(plant.name, plant.description, plant.image)
            }
        }
    }
}

data class FlowerPojo(val name: String, val description: Int, val image: Int)

@Composable
fun PlantCard(name: String, description: Int, image: Int) {
    Card(modifier = Modifier
        .padding(top = 5.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .background(color = Color.White)
        .shadow(2.dp),
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
            .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .padding(start = 5.dp),
                painter = painterResource(id = image),
                contentDescription = null
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = name, fontSize = 20.sp)
                Text(text = stringResource(id = description))
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
                .width(260.dp)
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


//// button navigation bar
//@Composable
//fun ListItem(name: String) {
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(24.dp)
//                .fillMaxWidth()
//        ) {
//            Row {
//                Column(
//                    modifier = Modifier.weight(1f),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(text = "Course")
//                    Text(
//                        text = name,
//                        style = TextStyle(
//                            fontWeight = FontWeight.ExtraBold,
//                            fontStyle = FontStyle.Normal
//                        )
//                    )
//                }
//
//                OutlinedButton(onClick = { /*TODO*/ }) {
//                    Text(text = "Show more")
//                }
//            }
//        }
//    }
//}


//LazyColumn(modifier = Modifier.fillMaxSize(),
//        contentPadding = PaddingValues(15.dp),
//    ){
//        item {
//            Row(modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 15.dp)
//                .shadow(5.dp)
//                .background(color = colorResource(id = R.color.softWhite)),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Column(modifier = Modifier.padding(10.dp)) {
//                    Image(modifier = Modifier
//                        .height(100.dp)
//                        .width(100.dp)
//                        .padding(start = 5.dp),
//                        painter = painterResource(id = plant.image),
//                        contentDescription = null
//                    )
//                    Text(text = "$count")
//                }
//                Column(modifier = Modifier.padding(10.dp)) {
//                    Text(text = plant.name, fontSize = 30.sp)
//                    Text(text = stringResource(id = plant.description))
//                }
//            }
//        }
//        items(platList) { plant ->
//            PlantCard(plant.name, plant.description, plant.imageRes)
//        }
//    }

//@Composable
//fun HomeScreens() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Home")
//    }
//}
//
//@Composable
//fun ProfileScreen() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = "Profile")
//        }
//    }
//}
//
//@Composable
//fun AccountScreen() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Account")
//    }
//}
//
//@Composable
//fun SettingsScreen() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = "Settings")
//        }
//    }
//}


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


//@Composable
//fun BottomNavigationBar(navController: NavHostController, backgroundColor: Color, contentColor: Color) {
//    val items = listOf(
//        BottomNavItem.Home,
//        BottomNavItem.Profile,
//        BottomNavItem.Contact,
//        BottomNavItem.Notification,
//        BottomNavItem.Setting
//    )
//    BottomNavigationBar(
//        navController = navController,
//        backgroundColor = backgroundColor,
//        contentColor = contentColor,
//    ) {
//        val navBackStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//        items.forEach { item ->
//            BottomNavigationItem(
//                icon = { Icon(painterResource = painterResource(id = item.icon), contentDescription = item.title) },
//                label = { Text(text = item.title, fontSize = 9.sp) },
//                selectedContentColor = Color.Black,
//                unselectedContentColor = Color.Black.copy(0.4f),
//                alwaysShowLabel = true,
//                selected = currentRoute == item.screen_route,
//                onClick = {
//                    navController.navigate(item.screen_route) {
//                        navController.graph.startDestinationRoute?.let { screen_route ->
//                            popUpTo(screen_route) {
//                                saveState = true
//                            }
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}

//@ExperimentalMaterial3Api
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Preview
//@Composable
//fun MainScreenView() {
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = {
//            BottomNavigationBar(
//                navController,
//                backgroundColor = colorResource(id = R.color.teal_200),
//                contentColor = Color.Black
//            )
//        }
//    ) {
//        NavigationGraph(navController = navController)
//    }
//}


//@Composable
//fun NavigationGraph(navController: NavHostController) {
//    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
//        composable(BottomNavItem.Home.screen_route) {
//            HomeScreen()
//        }
//        composable(BottomNavItem.Profile.screen_route) {
//            ProfileScreen()
//        }
//        composable(BottomNavItem.Contact.screen_route) {
//            ContactScreen()
//        }
//        composable(BottomNavItem.Notification.screen_route) {
//            NotificationScreen()
//        }
//        composable(BottomNavItem.Setting.screen_route) {
//            SettingScreen()
//        }
//    }
//}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Home Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "My Profile Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ContactScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Add Contact Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun NotificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Notification Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun SettingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Setting Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}
