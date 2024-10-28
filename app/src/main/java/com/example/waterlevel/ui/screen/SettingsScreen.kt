package com.example.waterlevel.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.waterlevel.R
import com.example.waterlevel.ui.theme.WaterLevelTheme

@Composable
fun SettingsScreen (
    viewModel: SettingsViewModel = hiltViewModel(),
){
    val onButtonClicked = { viewModel.addPlant() }
    SettingsDetails(onButtonClicked = onButtonClicked)
}

@Composable
fun SettingsDetails(onButtonClicked: () -> Unit) {
    Column {
        Text(text = "You are in settings place")
        Button(onClick = {
            onButtonClicked()
            println("Button clicked")
        }){
            Text(text = stringResource(id = R.string.add_plant))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    WaterLevelTheme {
        SettingsDetails(onButtonClicked = {})
    }
}