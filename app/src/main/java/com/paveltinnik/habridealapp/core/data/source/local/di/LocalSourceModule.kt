package com.paveltinnik.habridealapp.core.data.source.local.di

import android.content.Context
import androidx.room.Room
import com.paveltinnik.habridealapp.core.data.repository.LocalDataSourceRepositoryImpl
import com.paveltinnik.habridealapp.core.data.source.local.LocalDataSource
import com.paveltinnik.habridealapp.core.data.source.local.RoomLocalDataSource
import com.paveltinnik.habridealapp.core.data.source.local.db.NotesRoomDatabase
import com.paveltinnik.habridealapp.core.domain.repository.LocalDataSourceRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalSourceModuleProvider {

    @Provides
    fun provideNoteDao(database: NotesRoomDatabase) = database.noteDao()

    @Provides
    @Singleton
    fun providesLocalDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NotesRoomDatabase::class.java,
        "just_notes-database"
    ).build()

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class LocalSourceModuleBinder {

        @Binds
        abstract fun bindRoomLocalDataSource(
            roomLocalDataSource: RoomLocalDataSource
        ): LocalDataSource

        @Binds
        abstract fun bindDefaultJustNotesRepository(
            defaultJustNotesRepository: LocalDataSourceRepositoryImpl
        ): LocalDataSourceRepository
    }
}