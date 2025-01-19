package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroesTheme {
                SuperHeroesApp()
            }
        }
    }
}

@Composable
fun SuperHeroesApp() {

}


@Preview
@Composable
fun SuperHeroesAppPreview() {
    SuperHeroesTheme {
        SuperHeroesApp()
    }
}