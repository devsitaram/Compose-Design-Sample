package com.sitaram.composedesign.features.game

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.sitaram.composedesign.features.game.pojo.GameItems
import com.sitaram.composedesign.features.main.ScreenItem

val gameViewModel = GameViewModel()

@Composable
fun GameScreen(list: List<Any>? = null) {

    val context = LocalContext.current

    gameViewModel.getGames(context, onListReceived = {

//        Column(modifier = Modifier.fillMaxSize()) {
//            // Display the list of games
//            getGame(onListReceived)
//        }
    })
}


@SuppressLint("ComposableNaming")
@Composable
fun getGame(gameList: List<GameItems>?) {
    if (gameList != null) {
        LazyColumn {
            items(gameList) { game ->
                Text(text = game.title.toString())
            }
        }
    } else {
        // Show a loading indicator or error message when the list of games is null
        Text(text = "Loading...")
    }
}


//@Composable
//fun GameScreens(list: List<Any>? = null) {
//
//    val model: GameViewModel = viewModel()
//    val context = LocalContext.current
//
//    LaunchedEffect(key1 = true) {
//        model.getGames(context) // Fetch the list of games
//    }
//
//    val gameList: List<GameItems> by model.games.observeAsState(emptyList())
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        // Display the list of games
//        getGame(gameList)
//    }
//}


////    val context = LocalContext.current
//    val gameViewModel = GameViewModel()
////    gameViewModel.getGames(context) // call the getGames methods
////
//    val listOfGames = gameViewModel.gamesList
////
//    Column(modifier = Modifier.fillMaxSize()) {
//        // Display the list of games
//        getGame(listOfGames)
//    }
//}
