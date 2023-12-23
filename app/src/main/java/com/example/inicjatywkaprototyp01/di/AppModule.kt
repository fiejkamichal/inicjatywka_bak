package com.example.inicjatywkaprototyp01.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.inicjatywkaprototyp01.feature_game.data.data_source.PhaseDaoImpl
import com.example.inicjatywkaprototyp01.feature_game.data.repository.PhaseRepositoryImpl
import com.example.inicjatywkaprototyp01.feature_game.domain.repository.PhaseRepository
import com.example.inicjatywkaprototyp01.feature_game.domain.use_case.GetPhase
import com.example.inicjatywkaprototyp01.feature_game.domain.use_case.PhaseUseCases
import com.example.inicjatywkaprototyp01.feature_game.domain.use_case.StartInitiative
import com.example.inicjatywkaprototyp01.feature_game.domain.use_case.StopInitiative
import com.example.myapplication.PhaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePhaseDatabase(app: Application): PhaseDatabase {
        val driver: SqlDriver = AndroidSqliteDriver(PhaseDatabase.Schema, app, "phase")
        return PhaseDatabase(driver)
    }

    @Provides
    @Singleton
    fun providePhaseRepository(db: PhaseDaoImpl): PhaseRepository {
        return PhaseRepositoryImpl(db)
    }

    @Provides
    @Singleton
    fun providePhaseUseCases(repository: PhaseRepository): PhaseUseCases {
        return PhaseUseCases(
            startInitiative = StartInitiative(repository),
            stopInitiative = StopInitiative(repository),
            getPhase = GetPhase(repository)
        )
    }
}