package com.example.inicjatywkaprototyp01.di

import android.app.Application
import androidx.room.Room
import com.example.inicjatywkaprototyp01.feature_game.data.data_source.PhaseDatabase
import com.example.inicjatywkaprototyp01.feature_game.data.repository.PhaseRepositoryImpl
import com.example.inicjatywkaprototyp01.feature_game.domain.repository.PhaseRepository
import com.example.inicjatywkaprototyp01.feature_game.domain.use_case.GetPhase
import com.example.inicjatywkaprototyp01.feature_game.domain.use_case.PhaseUseCases
import com.example.inicjatywkaprototyp01.feature_game.domain.use_case.StartInitiative
import com.example.inicjatywkaprototyp01.feature_game.domain.use_case.StopInitiative
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
        return Room.databaseBuilder(
            app,
            PhaseDatabase::class.java,
            PhaseDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePhaseRepository(db: PhaseDatabase): PhaseRepository {
        return PhaseRepositoryImpl(db.phaseDao)
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