package com.sitaram.composedesign.login.compponents

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sitaram.composedesign.R
import com.sitaram.composedesign.home.HomeActivity
import com.sitaram.composedesign.ui.theme.Purple

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .heightIn(min = 40.dp)
            .padding(top = 5.dp),

        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.softBlack)
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 5.dp),

        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextFields(labelValue: String, painterResource: Painter) {
    // initialize the variable for entered text
    val textValue = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        label = { Text(text = labelValue) }, // init text
        value = textValue.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Purple,
            focusedLabelColor = Purple,
            cursorColor = Purple
        ),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFields(labelValue: String, painterResource: Painter) {
    // Initialize the variable for entered text
    val password = remember { mutableStateOf("") }

    val passwordVisible = remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        label = { Text(text = labelValue) },
        value = password.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Purple,
            focusedLabelColor = Purple,
            cursorColor = Purple
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                painterResource(R.drawable.ic_password_off)
            } else {
                painterResource(R.drawable.ic_password_visible)
            }
            val description = if (passwordVisible.value) {
                "Hide password"
            } else {
                "Show password"
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(painter = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckboxComponent() {
    var checkedState by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
    Checkbox(
            checked = checkedState,
            onCheckedChange = { checkedState = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.DarkGray,
                uncheckedColor = Color.Gray
            )
        )
        Text(text = if (checkedState) "Checked" else "Unchecked")
    }
}


@Composable
fun ButtonComponent() {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // Handle the result if needed
    }

    Button(
        modifier = Modifier.padding(16.dp),
        onClick = {
            val intent = Intent(/* Specify the target activity class */)
            launcher.launch(intent)
        }
    ) {
        Text(text = "Go to Another Activity")
    }
}
@Composable
fun ButtonComponent(value: String) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        /* Handle the result if needed */
        if (result.resultCode == Activity.RESULT_OK) {
            // Handle the result here
            val data: Intent? = result.data
            // Process the data or perform any necessary actions
        }
    }
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        onClick = {
            val intent = Intent(context, HomeActivity::class.java)
            launcher.launch(intent)
        },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    colorResource(id = R.color.purple_500),
//                    brush = Brush.horizontalGradient(listOf(Color.Blue, Color.Green)), // Gradient color
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}