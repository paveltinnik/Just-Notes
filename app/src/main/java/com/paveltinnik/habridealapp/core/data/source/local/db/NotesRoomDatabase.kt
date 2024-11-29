package com.paveltinnik.habridealapp.core.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paveltinnik.habridealapp.core.data.source.local.dao.NoteDao
import com.paveltinnik.habridealapp.core.data.source.local.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NotesRoomDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}