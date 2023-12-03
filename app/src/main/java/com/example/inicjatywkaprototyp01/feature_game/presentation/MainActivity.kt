package com.example.inicjatywkaprototyp01.feature_game.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.inicjatywkaprototyp01.feature_game.presentation.initial_phase.components.InitialPhaseScreen
import com.example.inicjatywkaprototyp01.feature_game.presentation.initiative_phase.components.InitiativePhaseScreen
import com.example.inicjatywkaprototyp01.feature_game.presentation.util.Screen
import com.example.inicjatywkaprototyp01.ui.theme.InicjatywkaPrototyp01Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InicjatywkaPrototyp01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.InitialPhaseScreen.route
                    ) {
                        composable(route = Screen.InitialPhaseScreen.route) {
                            InitialPhaseScreen(navController = navController)
                        }

                        composable(route = Screen.InitiativePhaseScreen.route) {
                            InitiativePhaseScreen(navController = navController)
                        }

                    }


                }
            }
        }
    }
}

