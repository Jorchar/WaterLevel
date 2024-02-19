package com.example.waterlevel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.waterlevel.ui.screen.AppOverlay
import com.example.waterlevel.ui.theme.WaterLevelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterLevelTheme {
                AppOverlay()
            }
        }
    }
}
