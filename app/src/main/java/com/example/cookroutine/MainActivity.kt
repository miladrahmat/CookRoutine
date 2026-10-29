package com.example.cookroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cookroutine.ui.RecipeListScreen
import com.example.cookroutine.ui.theme.CookRoutineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CookRoutineTheme() {
                RecipeListScreen()
            }
        }
    }
}