package com.example.inicjatywkaprototyp01.feature_game.data.data_source

import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase
import com.example.myapplication.PhaseDatabase
import javax.inject.Inject

class PhaseDaoImpl @Inject constructor(
    db: PhaseDatabase
) : PhaseDao {
    private val queries = db.phaseQueries

    override suspend fun setPhase(phase: Phase) {
        queries.setPhase(phase.value.name)
    }

    override suspend fun getPhase(): Phase? {
        return queries.getPhase {
            id, value ->
            Phase(
                id = id.toInt(),
                value = Phase.Phases.valueOf(value)
            )
        }.executeAsOneOrNull()
    }
}