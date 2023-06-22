package com.sitaram.composedesign.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val label: String, val route: String, val icon: ImageVector) {
    object Home : NavigationItem("Home", "home", Icons.Filled.Home)
    object Profile : NavigationItem("Profile", "profile", Icons.Filled.Person)
    object Account : NavigationItem("Account", "account", Icons.Filled.AccountCircle)
    object Settings : NavigationItem("Settings", "settings", Icons.Filled.Settings)
}