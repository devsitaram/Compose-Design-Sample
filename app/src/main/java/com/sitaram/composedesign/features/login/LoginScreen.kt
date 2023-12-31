package com.sitaram.composedesign.features.login

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.sitaram.composedesign.R
import com.sitaram.composedesign.features.util.CheckboxComponent
import com.sitaram.composedesign.features.util.HeadingTextComponent
import com.sitaram.composedesign.features.util.InputTextField
import com.sitaram.composedesign.features.util.NormalTextComponent
import com.sitaram.composedesign.features.util.PasswordTextField
import com.sitaram.composedesign.features.main.User

// Main/Parent UI design for Sign Up Screen
@Composable
fun ViewOfLoginScreen(navController: NavHostController) {
    val context = LocalContext.current
    val loginViewModel = LoginViewModel()

    var userName by remember { mutableStateOf("") }

    var userPassword by remember { mutableStateOf("") }

    // if the input fields are not empty then the button is visible
    val isDateValidated by remember {
        derivedStateOf {
            if (userName.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(context, "The fields is empty", Toast.LENGTH_LONG).show()
                return@derivedStateOf false
            } else {
                return@derivedStateOf true
            }
        }
    }

    // Login button click handler
    val onLoginClick: () -> Unit = {
        if (isDateValidated) {
            val isValidLogin = loginViewModel.loginDetails(userName, userPassword, context)
            if (isValidLogin == true) {
                // Navigate to the home screen
                navController.navigate(User.Main.route) {
                    // Kill the Login screen
                    popUpTo(User.Login.route) {
                        inclusive = true
                    }
                }
                Toast.makeText(context, "Login Successful.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "The fields is empty!", Toast.LENGTH_SHORT).show()
        }
    }

    // sign screen page
    Surface(
        modifier = Modifier
            .fillMaxSize() // size
            .background(Color.White) // background
            .padding(30.dp) // padding
    ) {
        // child layout file
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally // gravity center
        ) {
            NormalTextComponent(
                text = stringResource(id = R.string.hey),
                color = colorResource(id = R.color.softBlack)
            ) // text

            HeadingTextComponent(
                value = stringResource(id = R.string.login_your_details),
                color = colorResource(id = R.color.black)
            )

            Spacer(modifier = Modifier.height(50.dp)) // marginTop/space

            // username
            InputTextField(
                userName,
                painterResource = painterResource(id = R.drawable.ic_person),
                onValueChange = { userName = it },
                label = stringResource(id = R.string.userName),
                "Enter the valid username"
            )

            // password
            PasswordTextField(
                userPassword,
                painterResource = painterResource(id = R.drawable.ic_lock),
                onValueChange = { userPassword = it },
                label = stringResource(id = R.string.userPassword)
            )

            // checkbox
            CheckboxComponent()

            Spacer(modifier = Modifier.height(30.dp))

            // login button
            LoginButton(
                value = stringResource(id = R.string.login),
                onClickAction = onLoginClick
            )

            Spacer(modifier = Modifier.height(50.dp))
            Divider(modifier = Modifier.fillMaxWidth()) // divider
            // register text
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                NormalTextComponent(
                    text = stringResource(id = R.string.register_your),
                    color = colorResource(id = R.color.softBlack)
                )
                RegisterTextComponent(
                    value = stringResource(id = R.string.account),
                    navController = navController
                )
            }
        }
    }
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
        Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

// account
@Composable
fun RegisterTextComponent(value: String, navController: NavController) {
    ClickableText(
        text = AnnotatedString(value),
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 5.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        onClick = {
            navController.navigate(User.Register.route)
        }
    )
}