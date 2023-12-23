package com.example.inicjatywkaprototyp01.feature_game.data.data_source

import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase

interface PhaseDao {

    suspend fun getPhase(): Phase?

    suspend fun setPhase(phase: Phase)
}