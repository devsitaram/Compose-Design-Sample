package com.sitaram.composedesign.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sitaram.composedesign.features.home.ViewOfHomePage
import com.sitaram.composedesign.features.login.ViewOfLoginScreen
import com.sitaram.composedesign.features.register.ViewOfSignUpScreen

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Login") {
        // login and register page
        composable(User.Login.route) {
            ViewOfLoginScreen(navController)
        }

        composable(User.Register.route) {
            ViewOfSignUpScreen(navController)
        }

        composable(User.Main.route) {
            ViewOfHomePage(navController)
//            ViewOfMainPage(navController)
        }
    }
}








//@Composable
//fun MainScreens(platList: List<FlowerPojo>) {
//    Surface(modifier = Modifier.fillMaxSize().background(color = colorScheme.background).padding(15.dp)) {
//        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//            Column {
//                // row where image and title
//                Row(modifier = Modifier
//                    .fillMaxSize()
//                    .align(Alignment.CenterHorizontally),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Image(modifier = Modifier
//                        .width(100.dp)
//                        .padding(5.dp),
//                        painter = painterResource(id = R.mipmap.img_leave),
//                        contentDescription = null
//                    )
//                    Text(text = "Plants in", fontSize = 35.sp)
//                }
//                Text(text = "Cosmetics", fontSize = 35.sp)
//            }
//            // for loop
//            for (plant in platList) {
//                Row(modifier = Modifier.fillMaxSize().padding(top = 15.dp).shadow(5.dp).background(color = colorResource(id = R.color.softWhite)),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Image(modifier = Modifier.height(100.dp).width(100.dp).padding(start = 5.dp),
//                        painter = painterResource(id = plant.image),
//                        contentDescription = null
//                    )
//                    Column(modifier = Modifier.padding(10.dp)) {
//                        Text(text = plant.name, fontSize = 30.sp)
//                        Text(text = stringResource(id = plant.description))
//                    }
//                }
//            }
//        }
//    }
//}


// recycler
//@Composable
//fun ViewOfHomePage() {
//    val context = LocalContext.current
//
////    var number by remember { mutableIntStateOf("") }
//    var inputNum by remember { mutableStateOf("") }
//
//    val isNumberValid by remember(inputNum) {
//        derivedStateOf {
//            inputNum.isNotEmpty()
//        }
//    }
//
//    val platList = mutableListOf<FlowerPojo>()
//    platList.add(FlowerPojo("Aloe Vera", R.string.aloe_vera, R.mipmap.img_leave))
//
//    Surface(modifier = Modifier.fillMaxSize()) {
//        Column(modifier = Modifier.fillMaxSize().padding(15.dp).verticalScroll(rememberScrollState())
//        ) {
//            Row(modifier = Modifier.fillMaxSize().padding(bottom = 10.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                // input text
//                InputEditTextField(
//                    inputNum,
//                    onValueChange = { inputNum = it },
//                    text = "Enter a number"
//                )
//                ButtonWithBorder(
//                    onClickAction = {
//                        if (isNumberValid) {
////                            number = inputNum.toInt()
//                        } else {
//                            CoroutineScope(Dispatchers.Main).launch {
//                                Toast.makeText(context, "The field is empty!", Toast.LENGTH_LONG)
//                                    .show()
//                            }
//                        }
//                    }
//                )
//            }
//            var i = 1
//            if (number == 0) {
//                RecyclerView("Hello", 0)
//            }
//            while (i <= number) {
//                RecyclerView("Hello", i)
//                i++
//            }
//        }
//    }
//}

//
//@Composable
//fun RecyclerView(name: String, i: Int) {
//    var expanded by remember { mutableStateOf(false) }
//
//    val extraPadding by animateDpAsState(
//        if (expanded) 25.dp else 0.dp
//    )
//    Surface(
//        color = colorScheme.primary,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(bottom = extraPadding)
//            ) {
//                Text(text = "$i")
//                Text(text = name)
//            }
//            ElevatedButton(
//                onClick = { expanded = !expanded }
//            ) {
//                Text(if (expanded) "Show less" else "Show more")
//            }
//        }
//    }
//}
//
//@Composable
//fun ButtonWithBorder(onClickAction: () -> Unit) {
//    Button(
//        modifier = Modifier.padding(5.dp),
//        onClick = onClickAction,
//        border = BorderStroke(1.dp, Color.Gray),
//        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
//    ) {
//        Text(text = "Click", color = Color.DarkGray)
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun InputEditTextField(value: String, onValueChange: (String) -> Unit = {}, text: String) {
//    Column {
//        OutlinedTextField(
//            value = value,
//            onValueChange = onValueChange,
//            modifier = Modifier
//                .width(250.dp)
//                .height(70.dp)
//                .padding(top = 5.dp),
//            label = { Text(text) },
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedLabelColor = Purple,
//                cursorColor = Purple
//            ),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//        )
//        // if the fields is empty then show error message
//        if (value.isEmpty()) {
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(text = "The fields is empty!", color = Color.Red)
//        }
//    }
//}
//
//// button navigation bar
//@Composable
//fun ListItem(name: String) {
//    Surface(
//        color = colorScheme.primary,
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

// https://www.youtube.com/watch?v=hGg0HjcoP9w

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Preview
//@Composable
//fun MainScreen() {
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = {
//            BottomNavigationBar(navController)
//        }
//    ) {
////        Navigation(navController)
//    }
//
//}

//@Composable
//fun BottomNavigationBar(navController: NavController) {
//    val items = listOf(NavigationButtonIcon.Home, NavigationButtonIcon.Profile, NavigationButtonIcon.Notification, NavigationButtonIcon.Settings)
//        bottomBar = {
//            BottomNavigation(
//                backgroundColor = colorScheme.background
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

//@Composable
//fun NavigationButton(navController: NavController) {
//    NavHost(navController = navController as NavHostController, startDestination = NavigationButtonIcon.Home.route) {
//
//        composable(NavigationButtonIcon.Home.route) {
//            HomeScreen()
//        }
//
//        composable(NavigationButtonIcon.Profile.route) {
//            ProfileScreen()
//        }
//
//        composable(NavigationButtonIcon.Notification.route) {
//            AccountScreen()
//        }
//
//        composable(NavigationButtonIcon.Settings.route) {
////            SettingsScreen()
//        }
//    }
//}
//
//@Composable
//fun HomeScreen() {
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
//fun SettingsScreen(elementId: Int) {
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
