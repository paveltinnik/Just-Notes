package com.paveltinnik.habridealapp.core.data.mapper

import com.paveltinnik.habridealapp.core.data.source.local.model.NoteEntity
import com.paveltinnik.habridealapp.core.domain.model.Note

fun NoteEntity.toNote() = Note(id, title, description)
fun Note.toNoteEntity() = NoteEntity(id, title, description)