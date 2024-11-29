package com.paveltinnik.habridealapp.home.domain.usecase

import com.paveltinnik.habridealapp.core.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface GetAllNotesUseCase {

    operator fun invoke(): Flow<List<Note>>
}