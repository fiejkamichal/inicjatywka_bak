package com.example.inicjatywkaprototyp01.feature_game.domain.use_case

import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase
import com.example.inicjatywkaprototyp01.feature_game.domain.repository.PhaseRepository

class StopInitiative(
    private val repository: PhaseRepository
) {
    suspend operator fun invoke() {
        repository.setPhase(Phase(Phase.Phases.Initial,0))
    }
}