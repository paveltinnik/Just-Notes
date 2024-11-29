package com.paveltinnik.habridealapp.home.domain.usecase

import com.paveltinnik.habridealapp.core.domain.model.Note

interface DeleteNoteUseCase {

    suspend operator fun invoke(note: Note)
}