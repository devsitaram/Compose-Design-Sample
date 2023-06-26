package com.sitaram.composedesign.register

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sitaram.composedesign.R
import com.sitaram.composedesign.component_util.HeadingTextComponent
import com.sitaram.composedesign.component_util.InputTextField
import com.sitaram.composedesign.component_util.NormalTextComponent
import com.sitaram.composedesign.component_util.PasswordTextField
import com.sitaram.composedesign.login.LoginActivity


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
        Column (
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
                "The email is empty!"
            )

            // username
            InputTextField(
                userName,
                painterResource = painterResource(id = R.drawable.ic_profile),
                onValueChange = { userName = it },
                label = stringResource(id = R.string.userName),
                "The username is empty!"
            )

            // password
            PasswordTextField(
                userPassword,
                painterResource = painterResource(id = R.drawable.ic_password),
                onValueChange = { userPassword = it },
                label = stringResource(id = R.string.userPassword)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // the fields is not empty then button are visible
            // button
            RegisterButton(
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

@Composable
fun RegisterButton(value: String, isEnabled: Boolean = false) {
    val context = LocalContext.current
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentPadding = PaddingValues(15.dp),
        onClick = {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        },
        enabled = isEnabled
    ) {
        Text(
            text = value,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun ViewOfSignUPScreen() {
    SignUpScreen()
}