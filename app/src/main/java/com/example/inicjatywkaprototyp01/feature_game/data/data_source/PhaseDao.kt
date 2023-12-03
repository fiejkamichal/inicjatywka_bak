package com.example.inicjatywkaprototyp01.feature_game.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase

@Dao
interface PhaseDao {

    @Query("SELECT * FROM phase where id = 0")
    suspend fun getPhase(): Phase?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setPhase(phase: Phase)
}