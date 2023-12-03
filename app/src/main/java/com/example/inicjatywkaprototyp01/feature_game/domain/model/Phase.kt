package com.example.inicjatywkaprototyp01.feature_game.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Phase(
    val value: Phases,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val phases = listOf(Phases.Initial, Phases.Initiative)
    }
    enum class Phases {
        Initial,
        Initiative
    }
}
