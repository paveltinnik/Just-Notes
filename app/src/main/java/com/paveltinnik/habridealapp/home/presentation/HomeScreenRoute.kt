package com.paveltinnik.habridealapp.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun HomeScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToCreateNoteScreen: () -> Unit,
    navigateToUpdateNote: (String) -> Unit,
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        modifier = modifier,
        uiState = uiState,
        onCreateNoteFloatingActionButtonClick = navigateToCreateNoteScreen,
        onDeleteNoteButtonClick = { viewModel.handleEvent(HomeScreenUiEvent.OnDeleteClick(it)) },
        onNoteClick = navigateToUpdateNote
    )
}