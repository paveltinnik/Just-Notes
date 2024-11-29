package com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.impl

import com.paveltinnik.habridealapp.core.domain.model.Note
import com.paveltinnik.habridealapp.core.domain.repository.LocalDataSourceRepository
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.AddNoteUseCase
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.GetNoteByIdUseCase
import javax.inject.Inject

class GetNoteByIdUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): GetNoteByIdUseCase {

    override operator fun invoke(id: Int) =
        localDataSourceRepository.getNoteByIdFlow(id)
}