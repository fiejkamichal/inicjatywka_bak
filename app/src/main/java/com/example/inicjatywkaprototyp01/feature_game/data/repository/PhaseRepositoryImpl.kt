package com.example.inicjatywkaprototyp01.feature_game.data.repository

import com.example.inicjatywkaprototyp01.feature_game.data.data_source.PhaseDao
import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase
import com.example.inicjatywkaprototyp01.feature_game.domain.repository.PhaseRepository

class PhaseRepositoryImpl(
    private val dao: PhaseDao
) : PhaseRepository {
    override suspend fun getPhase(): Phase? {
        return dao.getPhase()
    }

    override suspend fun setPhase(phase: Phase): Phase {
        dao.setPhase(phase)
        return phase
    }
}