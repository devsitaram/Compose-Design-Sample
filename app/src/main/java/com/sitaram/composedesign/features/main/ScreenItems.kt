package com.sitaram.composedesign.features.main

import com.sitaram.composedesign.R

sealed class User(var route: String) {
    object Login : User("Login")
    object Register : User("Register")
    object Main: User("Main")
}

sealed class ScreenItem(var title: String, var icon: Int, var route: String) {
    object Home : ScreenItem("Home", R.drawable.ic_home, "Home")
    object Profile : ScreenItem("Profile", R.drawable.ic_person, "Profile")
    object Contact : ScreenItem("Contact", R.drawable.ic_setting, "Contact")
    object Notification : ScreenItem("Notification", R.drawable.ic_notification, "Notification")
    object Setting : ScreenItem("Setting", R.drawable.ic_setting, "Setting/{elementId}"){
        fun createRout(elementId: Int) = "Setting/$elementId"
    }
}