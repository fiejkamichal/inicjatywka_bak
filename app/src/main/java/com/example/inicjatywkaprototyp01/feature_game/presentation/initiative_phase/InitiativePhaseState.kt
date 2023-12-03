package com.example.inicjatywkaprototyp01.feature_game.presentation.initiative_phase

import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase

data class InitiativePhaseState(
    val currentPhase: Phase.Phases = Phase.Phases.Initiative
)
