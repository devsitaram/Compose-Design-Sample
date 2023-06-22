package com.sitaram.composedesign.login

import android.content.Intent
import android.widget.Toast
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
import com.sitaram.composedesign.component_util.Account
import com.sitaram.composedesign.component_util.CheckboxComponent
import com.sitaram.composedesign.component_util.HeadingTextComponent
import com.sitaram.composedesign.component_util.InputTextField
import com.sitaram.composedesign.component_util.NormalTextComponent
import com.sitaram.composedesign.component_util.PasswordTextField
import com.sitaram.composedesign.home.HomeActivity
import com.sitaram.composedesign.register.RegisterActivity

// Main/Parent UI design for Sign Up Screen
@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var userName by remember {
        mutableStateOf("")
    }

    var userPassword by remember {
        mutableStateOf("")
    }

    // if the input fields are not empty then the button is visible
    val isDateValidated by remember {
        derivedStateOf {
            if (userName.isEmpty() && userPassword.isEmpty()) {
                Toast.makeText(context,"The fields is empty",Toast.LENGTH_LONG).show()
                return@derivedStateOf false
            } else {
                return@derivedStateOf true
            }
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
                value = stringResource(id = R.string.login_your_details),
                color = colorResource(id = R.color.black)
            )

            Spacer(modifier = Modifier.height(20.dp)) // marginTop/space

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

            // checkbox
            CheckboxComponent()

            Spacer(modifier = Modifier.height(30.dp))

            // the fields is not empty then button are visible
            // button
            LoginButton(
                value = stringResource(id = R.string.login),
                onClickAction = {
                    if (isDateValidated) {
                        val intent = Intent(context, HomeActivity::class.java)
                        context.startActivity(intent)
                    } else {
                        Toast.makeText(context,"Invalid username!", Toast.LENGTH_LONG).show()
                    }
                },
            )
            Spacer(modifier = Modifier.height(70.dp))
            Divider(modifier = Modifier.fillMaxWidth()) // sign the divider
            // register text
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                NormalTextComponent(
                    value = stringResource(id = R.string.register_your),
                    color = colorResource(id = R.color.softBlack)
                )
                Account(
                    value = stringResource(id = R.string.account),
                    color = colorResource(id = R.color.purple_700)
                )
            }
        }
    }
}

// check the username validation
fun nameValidation(username: String): Boolean {
    val nameRegex = Regex("[a-zA-Z]\\d[a-zA-Z]")
    return username.matches(nameRegex)
}

@Composable
fun LoginButton(value: String, onClickAction: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentPadding = PaddingValues(15.dp),
        onClick = onClickAction,
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
    LoginScreen()
}