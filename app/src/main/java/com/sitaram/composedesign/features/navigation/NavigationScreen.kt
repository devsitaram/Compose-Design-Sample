package com.sitaram.composedesign.features.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.sitaram.composedesign.features.login.ViewOfLoginScreen
import com.sitaram.composedesign.features.main.ScreenItem
import com.sitaram.composedesign.features.main.User
import com.sitaram.composedesign.features.register.ViewOfSignUpScreen

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.Blue),
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
fun ContactScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Contact")
    }
}

@Composable
fun MessageScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Message")
    }
}
















//@Composable
//fun NavigationAppHost(navController: NavHostController) {
//    val context = LocalContext.current
//    NavHost(navController = navController, startDestination = "auth/login") {
//
//        // login and register page
//        navigation(
//            startDestination = "login",
//            route = "auth"
//        ) {
//            composable(User.Login.route) {
//                ViewOfLoginScreen(navController)
//            }
//
//            composable(User.Register.route) {
//                ViewOfSignUpScreen(navController)
//            }
//        }
//
//        // main page
//        navigation(
//            startDestination = "Home",
//            route = "auth"
//        ) {
//            composable(ScreenItem.Home.route) {
//                HomeScreen(navController)
//            }
//
//            composable(ScreenItem.Profile.route) {
//                ProfileScreen(navController)
//            }
//
//            composable(ScreenItem.Contact.route) {
//                ContactScreen(navController)
//            }
//
//            composable(ScreenItem.Notification.route){
//                NotificationScreen(navController)
//            }
//
//            composable(ScreenItem.Setting.route) {navBackStackEntity ->
//                val elementId = navBackStackEntity.arguments?.getInt("elementId")
//                if(elementId == null){
//                    Toast.makeText(context, "ElementId is required", Toast.LENGTH_SHORT).show()
//                } else {
//                    SettingsScreen(elementId)
//                }
//            }
//        }
//    }
//}
