package com.paveltinnik.habridealapp.home.domain.usecase.impl

import com.paveltinnik.habridealapp.core.domain.model.Note
import com.paveltinnik.habridealapp.core.domain.repository.LocalDataSourceRepository
import com.paveltinnik.habridealapp.home.domain.usecase.DeleteNoteUseCase
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): DeleteNoteUseCase {

    override suspend operator fun invoke(note: Note) {
        localDataSourceRepository.deleteNote(note)
    }
}