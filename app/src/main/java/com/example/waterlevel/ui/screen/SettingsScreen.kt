package com.example.waterlevel.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.waterlevel.ui.theme.WaterLevelTheme

@Composable
fun SettingsScreen (){
    SettingsDetails()
}

@Composable
fun SettingsDetails(){
    Column {
        Text(text = "You are in settings place")
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    WaterLevelTheme {
        SettingsDetails()
    }
}