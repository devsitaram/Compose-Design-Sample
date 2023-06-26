package values.home

import com.sitaram.composedesign.R

sealed class NavigationItem(val name: String, val route: String, val icon: Int) {
    object Home : NavigationItem("Home", "home", R.drawable.ic_home)
    object Profile : NavigationItem("Profile", "profile", R.drawable.ic_profile)
    object Notification : NavigationItem("Notification", "Notification", R.drawable.ic_notification)
    object Settings : NavigationItem("Settings", "settings", R.drawable.ic_setting)
}