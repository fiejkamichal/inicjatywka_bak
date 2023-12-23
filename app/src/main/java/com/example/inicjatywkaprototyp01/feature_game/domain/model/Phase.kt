package com.example.inicjatywkaprototyp01.feature_game.domain.model

data class Phase(
    val value: Phases,
    val id: Int? = null
) {
    companion object {
        val phases = listOf(Phases.Initial, Phases.Initiative)
    }
    enum class Phases {
        Initial,
        Initiative
    }
}
