package com.example.inicjatywkaprototyp01.feature_game.presentation.initial_phase

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inicjatywkaprototyp01.feature_game.domain.model.Phase
import com.example.inicjatywkaprototyp01.feature_game.domain.use_case.PhaseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitialPhaseViewModel @Inject constructor(
    private val phaseUseCases: PhaseUseCases
) : ViewModel() {

    private val _state = mutableStateOf(InitialPhaseState())
    val state: State<InitialPhaseState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var getPhaseJob: Job? = null

    init {
        getPhase()
    }

    fun onEvent(event: InitialPhaseEvent){
        when(event){
            is InitialPhaseEvent.StartInitiative ->{
                viewModelScope.launch {
                    phaseUseCases.startInitiative()
                    _eventFlow.emit(UiEvent.StartInitiative)
                }
            }
        }
    }

    fun getPhase(): Phase.Phases {
        var phase:Phase.Phases = Phase.Phases.Initial
        getPhaseJob?.cancel()
        getPhaseJob = viewModelScope.launch {
            phase = phaseUseCases.getPhase()
            _state.value = state.value.copy(
                currentPhase = phase
            )
        }
        return phase
    }

    sealed class UiEvent {
        object StartInitiative: UiEvent()
    }

}