package com.paveltinnik.habridealapp.home.domain.usecase.impl

import com.paveltinnik.habridealapp.core.domain.model.Note
import com.paveltinnik.habridealapp.core.domain.repository.LocalDataSourceRepository
import com.paveltinnik.habridealapp.home.domain.usecase.GetAllNotesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotesUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
) : GetAllNotesUseCase {

    override operator fun invoke() = localDataSourceRepository.getAllNotesFlow()
}