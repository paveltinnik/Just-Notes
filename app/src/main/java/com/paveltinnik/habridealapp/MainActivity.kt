package com.paveltinnik.habridealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.paveltinnik.habridealapp.navigation.Navigation
import com.paveltinnik.habridealapp.ui.theme.HabrIdealAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabrIdealAppTheme(dynamicColor = false) {
                Navigation()
            }
        }
    }
}