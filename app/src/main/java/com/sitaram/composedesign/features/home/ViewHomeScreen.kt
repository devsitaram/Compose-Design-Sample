package com.sitaram.composedesign.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sitaram.composedesign.R
import com.sitaram.composedesign.features.home.pojo.FlowerPojo
import com.sitaram.composedesign.features.main.ScreenItem
import com.sitaram.composedesign.features.navigation.ContactScreen
import com.sitaram.composedesign.features.navigation.HomeScreen
import com.sitaram.composedesign.features.navigation.NotificationScreen
import com.sitaram.composedesign.features.navigation.ProfileScreen
import com.sitaram.composedesign.features.navigation.SettingsScreen

@Composable
fun HomeScreens(navController: NavHostController) {

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
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "\uD83C\uDF3F  Plants and Flowers",
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )
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

//https://developer.android.com/jetpack/compose/navigation
