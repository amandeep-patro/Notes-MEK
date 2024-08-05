package com.adp.mongoexpressnotes.data.repository

import android.util.Log
import com.adp.mongoexpressnotes.common.util.Resource
import com.adp.mongoexpressnotes.data.remote.NotesAPI
import com.adp.mongoexpressnotes.domain.models.Notes
import com.adp.mongoexpressnotes.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class NotesRepositoryImpl(
    private val notesAPI : NotesAPI
) : NotesRepository{
    override suspend fun saveNotes(notes: Notes): Flow<Resource<String>> = flow{

        emit(Resource.Loading())

        val status : Int = notesAPI.saveNotes(notes).code()

        try{
            if(status == 201){
                emit(Resource.Success("Notes saved successfully!"))
            }else{
                emit(Resource.Error("Unable to save notes!"))
            }
        }
        catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        } catch (e: HttpException) {
            emit(Resource.Error("An unexpected error occurred."))
        }
    }

    override suspend fun getNotes(): Flow<Resource<List<Notes>>> = flow {
        emit(Resource.Loading())
        try {
            val response = notesAPI.getNotes()
            val status = response.code()
            val notesList = response.body()
            if (status == 200 && notesList != null) {
                // Log the contents of notesList
                notesList.forEach { note ->
                    Log.d("NotesRepository", "Fetched Note: ${note._id}, ${note.noteTitle}, ${note.noteDescription}, ${note.notePriority}")
                }
                emit(Resource.Success(notesList))
            } else {
                val errorMessage = "Unable to get notes!"
                // Log the error message
                Log.e("NotesRepository", errorMessage)
                emit(Resource.Error(errorMessage))
            }
        } catch (e: IOException) {
            val errorMessage = "Couldn't reach server. Check your internet connection."
            // Log the error message
            Log.e("NotesRepository", errorMessage, e)
            emit(Resource.Error(errorMessage))
        } catch (e: HttpException) {
            val errorMessage = "An unexpected error occurred."
            // Log the error message
            Log.e("NotesRepository", errorMessage, e)
            emit(Resource.Error(errorMessage))
        }
    }

    override suspend fun deleteNoteById(id: String): Flow<Resource<String>> = flow {
        emit(Resource.Loading())
        try {
            val status = notesAPI.deleteNoteById(id).code()
            if(status == 200){
                emit(Resource.Success("deleted"))
            }else{
                emit(Resource.Error("delete failed"))
            }
        }
        catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        } catch (e: HttpException) {
            emit(Resource.Error("An unexpected error occurred."))
        }
    }

    override suspend fun updateNoteById(id: String, notes: Notes): Flow<Resource<Notes>> = flow {
        emit(Resource.Loading())
        try {
            val response = notesAPI.updateNoteById(id, notes)
            val status = response.code()
            val updatedNote = response.body()
            if (status == 200 && updatedNote != null) {
                emit(Resource.Success(updatedNote))
            } else {
                emit(Resource.Error("Unable to update note!"))
            }
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        } catch (e: HttpException) {
            emit(Resource.Error("An unexpected error occurred."))
        }
    }
}