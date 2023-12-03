package com.example.inicjatywkaprototyp01.feature_game.domain.use_case

import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase
import com.example.inicjatywkaprototyp01.feature_game.domain.repository.PhaseRepository

class GetPhase (
    private val repository: PhaseRepository
) {
    suspend operator fun invoke(): Phase.Phases {
        return repository.getPhase()?.value ?: repository.setPhase(Phase(Phase.Phases.Initial,0)).value

    }
}