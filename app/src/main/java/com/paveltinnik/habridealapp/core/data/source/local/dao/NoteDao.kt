package com.paveltinnik.habridealapp.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.paveltinnik.habridealapp.core.data.source.local.model.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM noteEntity")
    fun getAllNotes(): Flow<List<NoteEntity>>
    @Insert
    fun insertNote(note: NoteEntity)
    @Update
    fun updateNote(note: NoteEntity)
    @Query("SELECT * FROM noteEntity WHERE id=:id")
    fun getNoteById(id: Int): Flow<NoteEntity>
    @Delete
    fun delete(note: NoteEntity)
}