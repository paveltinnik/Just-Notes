package com.paveltinnik.habridealapp.create_and_update_note.domain.usecase

import com.paveltinnik.habridealapp.core.domain.model.Note

interface AddNoteUseCase {

    suspend operator fun invoke(note: Note)
}