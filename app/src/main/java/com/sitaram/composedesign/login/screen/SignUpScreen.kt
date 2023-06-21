package com.sitaram.composedesign.login.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sitaram.composedesign.R
import com.sitaram.composedesign.login.compponents.ButtonComponent
import com.sitaram.composedesign.login.compponents.CheckboxComponent
import com.sitaram.composedesign.login.compponents.HeadingTextComponent
import com.sitaram.composedesign.login.compponents.InputTextFields
import com.sitaram.composedesign.login.compponents.NormalTextComponent
import com.sitaram.composedesign.login.compponents.PasswordTextFields


// Main/Parent UI design for Sign Up Screen
@Composable
fun SignUpScreen() {
    // sign screen page
    Surface(
        modifier = Modifier
            .fillMaxSize() // size
            .background(Color.White) // background
            .padding(20.dp) // padding
//            .align(Alignment.Center) // gravity center
    ) {
        // child layout file
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally // gravity center
        ) {
            NormalTextComponent(value = stringResource(id = R.string.hey)) // text

            HeadingTextComponent(value = stringResource(id = R.string.create_an_account))
            Spacer(modifier = Modifier.height(20.dp)) // marginTop/space

            // email
            InputTextFields(
                labelValue = stringResource(id = R.string.userEmail),
                painterResource(id = R.drawable.ic_email)
            )

            // username
            InputTextFields(
                labelValue = stringResource(id = R.string.userName),
                painterResource = painterResource(id = R.drawable.ic_profile)
            )

            // password
            PasswordTextFields(
                labelValue = stringResource(id = R.string.userPassword),
                painterResource = painterResource(id = R.drawable.ic_password)
            )

            // checkbox
            CheckboxComponent()

            Spacer(modifier = Modifier.height(30.dp))
            // button
            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(70.dp))
            Divider(modifier = Modifier.fillMaxWidth()) // usign the divider
            // register text
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                NormalTextComponent(value = stringResource(id = R.string.register_your))
                NormalTextComponent(value = stringResource(id = R.string.account))
            }
        }
    }
}

@Preview
@Composable
fun ViewOfSignUPScreen() {
    SignUpScreen()
}