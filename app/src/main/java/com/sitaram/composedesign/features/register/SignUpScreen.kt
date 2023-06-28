package com.sitaram.composedesign.features.register

import android.content.Context
import android.content.Intent
import android.util.Log
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
import com.sitaram.composedesign.features.component_util.HeadingTextComponent
import com.sitaram.composedesign.features.component_util.InputTextField
import com.sitaram.composedesign.features.component_util.NormalTextComponent
import com.sitaram.composedesign.features.component_util.OnclickTextComponent
import com.sitaram.composedesign.features.component_util.PasswordTextField
import com.sitaram.composedesign.features.database.room.DatabaseHelper
import com.sitaram.composedesign.features.database.room.UserPojo
import com.sitaram.composedesign.features.database.sqlite.RoomDBHelper
import com.sitaram.composedesign.features.home.HomeActivity
import com.sitaram.composedesign.features.login.LoginActivity
import com.sitaram.composedesign.features.login.loginDetails
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.Objects


// Main/Parent UI design for Sign Up Screen
@Composable
fun ViewOfSignUPScreen(databaseHelper: RoomDBHelper?) {

    val context = LocalContext.current

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
    val isNotEmpty by remember {
        derivedStateOf {
            !userEmail.isEmpty() && !userName.isEmpty() && !userPassword.isEmpty()
        }
    }

    // sign screen page
    Surface(
        modifier = Modifier
            .fillMaxSize() // size
            .background(Color.White) // background
            .padding(30.dp) // padding
//            .align(Alignment.Center) // gravity center
    ) {
        // child layout file
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
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

            Spacer(modifier = Modifier.height(40.dp)) // marginTop/space
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

            // button
            RegisterButton(
                value = stringResource(id = R.string.signup),
                isEnabled = isNotEmpty,
                onClickAction = {
                    if (isNotEmpty) {
                        registerDetails(userEmail, userName, userPassword, databaseHelper, context)
                    } else {
                        Toast.makeText(context, "Invalid username!", Toast.LENGTH_LONG).show()
                    }
                },
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
                OnclickTextComponent(
                    value = stringResource(id = R.string.account),
                    context = context
                )
            }
        }
    }
}

@Composable
fun RegisterButton(value: String, isEnabled: Boolean = false, onClickAction: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentPadding = PaddingValues(15.dp),
        enabled = isEnabled,
        onClick = onClickAction,
    ) {
        Text(
            text = value,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

fun registerDetails(userEmail: String, userName: String, userPassword: String, databaseHelper: RoomDBHelper?, context: Context) {
    // initialize the variable
    val isValidEmail = emailValidation(userEmail)
    val isValidName = nameValidation(userName)

    if (isValidEmail && isValidName) {
        // call the register button click method
        val isRegisterSuccess= databaseHelper?.registerUser(userEmail, userName, userPassword)
        if (isRegisterSuccess == true){
            navigateToLoginPage(context = context)
        } else {
            Toast.makeText(context, "Please enter the valid data!", Toast.LENGTH_SHORT).show()
        }
    } else {
        Toast.makeText(context, "Enter the valid details!", Toast.LENGTH_SHORT).show()
    }
}

// check the username validation
fun emailValidation(email: String): Boolean {
    // get text fields text
    val emailPattern = Regex("[a-zA-Z\\d._-]+@[a-z]+.+[a-z]+")
    return email.matches(emailPattern)
}

// check the username validation
fun nameValidation(username: String): Boolean {
    val nameRegex = Regex("[A-Za-z\\s]+")
    return username.matches(nameRegex)
}

// check the username validation
fun passwordValidation(password: String): Boolean {
    val nameRegex = Regex("[a-zA-Z0-9]")
    return password.matches(nameRegex)
}

// navigation
fun navigateToLoginPage(context: Context) {
    val intent = Intent(context, LoginActivity::class.java)
    context.startActivity(intent)
    Toast.makeText(context, "Register Success.", Toast.LENGTH_SHORT).show()
}

@Preview
@Composable
fun ViewOfSignUPScreen() {
//    SignUpScreen()
}