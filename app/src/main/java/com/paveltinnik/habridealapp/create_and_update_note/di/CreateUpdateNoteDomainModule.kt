package com.paveltinnik.habridealapp.create_and_update_note.di

import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.AddNoteUseCase
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.GetNoteByIdUseCase
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.UpdateNoteUseCase
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.impl.AddNoteUseCaseImpl
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.impl.GetNoteByIdUseCaseImpl
import com.paveltinnik.habridealapp.create_and_update_note.domain.usecase.impl.UpdateNoteUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CreateUpdateNoteDomainModule {

    @Binds
    abstract fun bindAddNoteUseCase(
        addNoteUseCaseImpl: AddNoteUseCaseImpl
    ): AddNoteUseCase

    @Binds
    abstract fun bindGetNoteByIdUseCase(
        getNoteByIdUseCaseImpl: GetNoteByIdUseCaseImpl
    ): GetNoteByIdUseCase

    @Binds
    abstract fun bindUpdateNoteUseCase(
        updateNoteUseCaseImpl: UpdateNoteUseCaseImpl
    ): UpdateNoteUseCase
}