package com.paveltinnik.habridealapp.create_and_update_note.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue

@Composable
internal fun CreateAndUpdateNoteRoute(
    modifier: Modifier = Modifier,
    viewModel: CreateAndUpdateNoteViewModel = hiltViewModel(),
    topBarTitle: Int?,
    navigateToHomeScreen: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CreateAndUpdateNoteScreen(
        modifier = modifier,
        uiState = uiState,
        topBarTitle = topBarTitle,
        onSaveButtonClick = { viewModel.handleEvent(CreateAndUpdateNoteUiEvent.OnSaveClicked) },
        navigateToHomeScreen = navigateToHomeScreen,
        onTitleChanged = { viewModel.handleEvent(CreateAndUpdateNoteUiEvent.OnTitleChanged(it)) },
        onDescriptionChanged = { viewModel.handleEvent(CreateAndUpdateNoteUiEvent.OnDescriptionChanged(it)) }
    )
}