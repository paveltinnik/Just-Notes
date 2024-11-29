package com.paveltinnik.habridealapp.create_and_update_note.domain.usecase

import com.paveltinnik.habridealapp.core.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface GetNoteByIdUseCase {

    operator fun invoke(id: Int): Flow<Note>
}