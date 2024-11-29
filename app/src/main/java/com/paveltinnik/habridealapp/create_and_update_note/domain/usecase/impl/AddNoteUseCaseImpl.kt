package com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.impl

import com.paveltinnik.habridealapp.core.domain.model.Note
import com.paveltinnik.habridealapp.core.domain.repository.LocalDataSourceRepository
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.AddNoteUseCase
import javax.inject.Inject

class AddNoteUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): AddNoteUseCase{

    override suspend operator fun invoke(note: Note) {
        localDataSourceRepository.addNote(note)
    }
}