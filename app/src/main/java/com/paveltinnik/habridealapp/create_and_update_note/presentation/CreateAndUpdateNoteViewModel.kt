package com.paveltinnik.habridealapp.create_and_update_note.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paveltinnik.habridealapp.core.domain.model.Note
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.AddNoteUseCase
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.GetNoteByIdUseCase
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.UpdateNoteUseCase
import com.paveltinnik.habridealapp.create_and_update_note.presentation.navigation.NOTE_ID_ARG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal sealed interface CreateAndUpdateNoteUiEvent {

    data class OnTitleChanged(val title: String): CreateAndUpdateNoteUiEvent
    data class OnDescriptionChanged(val description: String): CreateAndUpdateNoteUiEvent
    data object OnSaveClicked: CreateAndUpdateNoteUiEvent
}

sealed interface CreateAndUpdateNoteUiState {
    data class Content(
        val id: Int = 0,
        val title: String = "",
        val description: String = ""
    ): CreateAndUpdateNoteUiState
}

@HiltViewModel
internal class CreateAndUpdateNoteViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {

    private val noteId: String? = savedStateHandle[NOTE_ID_ARG]

    init {
        if (noteId != null) loadNote(noteId = noteId.toInt())
    }

    private val _uiState = MutableStateFlow<CreateAndUpdateNoteUiState>(
        CreateAndUpdateNoteUiState.Content()
    )
    val uiState = _uiState.asStateFlow()

    fun handleEvent(event: CreateAndUpdateNoteUiEvent) {
        when (event) {
            is CreateAndUpdateNoteUiEvent.OnTitleChanged -> setTitle(event.title)
            is CreateAndUpdateNoteUiEvent.OnDescriptionChanged -> setDescription(event.description)
            is CreateAndUpdateNoteUiEvent.OnSaveClicked -> addOrUpdateNote(noteId)
        }
    }

    private fun loadNote(noteId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val note = getNoteByIdUseCase(noteId).first()
            _uiState.update {
                CreateAndUpdateNoteUiState.Content(
                    id = noteId,
                    title = note.title,
                    description = note.description
                )
            }
        }
    }

    private fun setTitle(title: String) {
        _uiState.update {
            (it as CreateAndUpdateNoteUiState.Content).copy(title = title)
        }
    }

    private fun setDescription(description: String) {
        _uiState.update {
            (it as CreateAndUpdateNoteUiState.Content).copy(description = description)
        }
    }

    private fun addOrUpdateNote(noteId: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val state = _uiState.value as CreateAndUpdateNoteUiState.Content
            val note = Note(
                id = state.id,
                title = state.title,
                description = state.description
            )

            if (noteId != null) {
                updateNoteUseCase(note)
            } else addNoteUseCase(note)
        }
    }
}