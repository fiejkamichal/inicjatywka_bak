package com.example.inicjatywkaprototyp01.feature_game.presentation.initial_phase

import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase

data class InitialPhaseState(
    val currentPhase: Phase.Phases = Phase.Phases.Initial
)
