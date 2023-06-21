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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sitaram.composedesign.R
import com.sitaram.composedesign.login.compponents.ButtonComponent
import com.sitaram.composedesign.login.compponents.CheckboxComponent
import com.sitaram.composedesign.login.compponents.HeadingTextComponent
import com.sitaram.composedesign.login.compponents.InputTextField
import com.sitaram.composedesign.login.compponents.NormalTextComponent
import com.sitaram.composedesign.login.compponents.PasswordTextField


// Main/Parent UI design for Sign Up Screen
@Composable
fun SignUpScreen() {

    var userEmail by remember {
        mutableStateOf("")
    }

    var userName by remember {
        mutableStateOf("")
    }

    var userPassword by remember {
        mutableStateOf("")
    }

    // if the input fields are not empty then the button is visible
    val isDateValidated by remember {
        derivedStateOf {
            !userEmail.isEmpty() && !userName.isEmpty() && !userPassword.isEmpty()
        }
    }


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
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally // gravity center
        ) {
            NormalTextComponent(
                value = stringResource(id = R.string.hey),
                color = colorResource(id = R.color.softBlack)
            ) // text

            HeadingTextComponent(
                value = stringResource(
                    id = R.string.create_an_account
                ),
                color = colorResource(id = R.color.black)
            )

            Spacer(modifier = Modifier.height(20.dp)) // marginTop/space
            // email
            InputTextField(
                userEmail,
                painterResource(id = R.drawable.ic_email),
                onValueChange = { userEmail = it },
                label = stringResource(id = R.string.userEmail),
            )

            // username
            InputTextField(
                userName,
                painterResource = painterResource(id = R.drawable.ic_profile),
                onValueChange = { userName = it },
                label = stringResource(id = R.string.userName),
            )

            // password
            PasswordTextField(
                userPassword,
                painterResource = painterResource(id = R.drawable.ic_password),
                onValueChange = { userPassword = it },
                label = stringResource(id = R.string.userPassword)
            )

            // checkbox
            CheckboxComponent()

            Spacer(modifier = Modifier.height(30.dp))

            // the fields is not empty then button are visible
            // button
            ButtonComponent(
                value = stringResource(id = R.string.signup),
                isEnabled = isDateValidated
            )

            Spacer(modifier = Modifier.height(70.dp))
            Divider(modifier = Modifier.fillMaxWidth()) // usign the divider
            // register text
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                NormalTextComponent(
                    value = stringResource(id = R.string.login_your),
                    color = colorResource(id = R.color.softBlack)
                )
                NormalTextComponent(
                    value = stringResource(id = R.string.account),
                    color = colorResource(id = R.color.purple_700)
                )
            }
        }
    }
}

@Preview
@Composable
fun ViewOfSignUPScreen() {
    SignUpScreen()
}