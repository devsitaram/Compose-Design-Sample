package com.sitaram.composedesign.features.game

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.sitaram.composedesign.features.game.pojo.GameItems
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

// recycler
@Composable
fun GameScreen(navController: NavHostController) {
    val context = LocalContext.current

    val gameViewModel = GameViewModel()
    gameViewModel.setGames(context)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Game Page")
    }
}

fun getGame(listOfGames: List<GameItems>?){

}