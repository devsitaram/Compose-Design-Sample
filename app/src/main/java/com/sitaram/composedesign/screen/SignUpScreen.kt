package com.sitaram.composedesign.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import com.sitaram.composedesign.R
import com.sitaram.composedesign.compponents.NormalTextComponent


// UI design for Sign Up Screen
@Composable
fun signUpScreen(){
    // sign screen page
    Surface(
        modifier = Modifier
            .fillMaxSize() // size
            .background(Color.White) // background()
            .padding(28.dp) // padding
    ) {
        NormalTextComponent(value = stringResource(id = R.string.hey))
    }
}

@Preview
@Composable
fun HasDefaultViewOfSignScreen(){
    signUpScreen()
}