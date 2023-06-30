package com.sitaram.composedesign.features.main

import com.sitaram.composedesign.R

sealed class User(var route: String) {
    object Login : User("Login")
    object Register : User("Register")
    object Main: User("Main")
}

sealed class ScreenItem(var icon: Int, var route: String) {
    object Home : ScreenItem(R.drawable.ic_home, "Home")
    object Profile : ScreenItem(R.drawable.ic_person, "Profile")
    object Message : ScreenItem(R.drawable.ic_message, "Message")
    object Contact : ScreenItem(R.drawable.ic_contact, "Contact")
    object Setting : ScreenItem(R.drawable.ic_setting, "Setting")
}