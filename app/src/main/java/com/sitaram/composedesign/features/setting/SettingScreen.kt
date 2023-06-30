package com.sitaram.composedesign.features.setting

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sitaram.composedesign.R

@Composable
fun SettingsScreen(navController: NavHostController) {
    val showDialog = remember { mutableStateOf(false) }
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(5.dp),
            horizontalArrangement = Arrangement.End // gravity end
        ) {
            IconButton(
                onClick = { showDialog.value = true }) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Add Icon",
                    modifier = Modifier.size(50.dp),
                    tint = Color.LightGray,
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Green),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Setting",
                color = Color.White,
                fontSize = 50.sp
            )
        }

        // if press the button the show the dialog box
        if (showDialog.value) {
            DialogBox(onDismiss = { showDialog.value = false })
        }
    }
}

// logout dialog box
@Composable
fun DialogBox(onDismiss: () -> Unit) {
    val activity = (LocalContext.current as Activity)
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(stringResource(id = R.string.logout)) },
        text = { Text(text = "Are you sure you want to log out?") },
        modifier = Modifier.fillMaxWidth(),
        dismissButton = {
            TextButton(
                onClick = { onDismiss() }
            ) {
                Text(text = "No")
            }
        },
        confirmButton = {
            TextButton(
                onClick = { activity.finish() }
            ) {
                Text(text = "Yes")
            }
        }
    )
}
