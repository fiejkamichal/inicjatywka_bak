package com.example.inicjatywkaprototyp01.feature_game.domain.repository

import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase

interface PhaseRepository {
    suspend fun getPhase(): Phase?

    suspend fun setPhase(phase: Phase): Phase
}