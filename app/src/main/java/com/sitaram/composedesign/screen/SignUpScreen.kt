package com.sitaram.composedesign.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sitaram.composedesign.R
import com.sitaram.composedesign.compponents.HeadingTextComponent
import com.sitaram.composedesign.compponents.InputTextFields
import com.sitaram.composedesign.compponents.NormalTextComponent

// Main/Parent UI design for Sign Up Screen
@Composable
fun SignUpScreen() {
    // sign screen page
    Surface(
        modifier = Modifier
            .fillMaxSize() // size
            .background(Color.White) // background()
            .padding(20.dp) // padding
    ) {
        // child layout file
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.create_an_account))
            HeadingTextComponent(value = stringResource(id = R.string.create_an_account))
            Spacer(modifier = Modifier.height(20.dp))
            InputTextFields(
                labelValue = stringResource(id = R.string.userEmail),
                painterResource(id = R.drawable.ic_email)
            )

            InputTextFields(
                labelValue = stringResource(id = R.string.userName),
                painterResource = painterResource(id = R.drawable.ic_profile)
            )
            InputTextFields(
                labelValue = stringResource(id = R.string.userPassword),
                painterResource = painterResource(id = R.drawable.ic_password)
            )
        }
    }
}

@Preview
@Composable
fun HasDefaultViewOfSignScreen() {
    SignUpScreen()
}