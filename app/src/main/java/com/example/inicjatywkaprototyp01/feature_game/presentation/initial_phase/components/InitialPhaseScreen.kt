package com.example.inicjatywkaprototyp01.feature_game.presentation.initial_phase.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.inicjatywkaprototyp01.feature_game.presentation.initial_phase.InitialPhaseEvent
import com.example.inicjatywkaprototyp01.feature_game.presentation.initial_phase.InitialPhaseViewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitialPhaseScreen (
    navController: NavController,
    viewModel: InitialPhaseViewModel = hiltViewModel()
){

    val currentPhaseState = viewModel.state.value

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is InitialPhaseViewModel.UiEvent.StartInitiative -> {
                    navController.navigate(route = "initiative_phase_screen")
                }
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(InitialPhaseEvent.StartInitiative)
            }) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Start Inicjatywy")
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier.padding(16.dp)
    ) {
        innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ){
            Text(text = "Ekran startowy")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = currentPhaseState.currentPhase.toString())
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}