package com.sitaram.composedesign.home.pojo

import com.sitaram.composedesign.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_home, "home")
    object Profile : BottomNavItem("Profile", R.drawable.ic_person, "Profile")
    object Contact : BottomNavItem("Contact", R.drawable.ic_setting, "Contact")
    object Notification : BottomNavItem("Notification", R.drawable.ic_notification, "notification")
    object Setting : BottomNavItem("Setting", R.drawable.ic_setting, "Setting")
}