package com.adp.mongoexpressnotes.domain.repository

import com.adp.mongoexpressnotes.common.util.Resource
import com.adp.mongoexpressnotes.domain.models.Notes
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    suspend fun saveNotes(notes: Notes) : Flow<Resource<String>>

    suspend fun getNotes () : Flow<Resource<List<Notes>>>

    suspend fun deleteNoteById(id: String): Flow<Resource<String>>

    suspend fun updateNoteById(id: String, notes: Notes): Flow<Resource<Notes>>
}