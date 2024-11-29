package com.paveltinnik.habridealapp.core.data.repository

import com.paveltinnik.habridealapp.core.data.source.local.LocalDataSource
import com.paveltinnik.habridealapp.core.domain.model.Note
import com.paveltinnik.habridealapp.core.domain.repository.LocalDataSourceRepository
import javax.inject.Inject

class LocalDataSourceRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
): LocalDataSourceRepository {

    override fun getAllNotesFlow() = localDataSource.getAllNotesFlow()

    override fun getNoteByIdFlow(id: Int) = localDataSource.getNoteByIdFlow(id)

    override suspend fun addNote(note: Note) = localDataSource.addNote(note)

    override suspend fun updateNote(note: Note) = localDataSource.updateNote(note)

    override suspend fun deleteNote(note: Note) =localDataSource.deleteNote(note)
}