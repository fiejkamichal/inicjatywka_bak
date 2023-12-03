package com.example.inicjatywkaprototyp01.feature_game.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase

@Database(
    entities = [Phase::class],
    version = 1,
    exportSchema = false
)
abstract class PhaseDatabase: RoomDatabase() {
    abstract val phaseDao: PhaseDao
    companion object {
        const val DATABASE_NAME = "phase_db"
    }
}