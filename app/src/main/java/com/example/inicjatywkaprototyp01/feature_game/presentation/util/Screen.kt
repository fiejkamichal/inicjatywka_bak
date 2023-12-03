package com.example.inicjatywkaprototyp01.feature_game.presentation.util

sealed class Screen(val route: String) {
    object InitialPhaseScreen: Screen("initial_phase_screen")
    object InitiativePhaseScreen: Screen("initiative_phase_screen")
}
