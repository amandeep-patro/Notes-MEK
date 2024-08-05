package com.adp.mongoexpressnotes.data.repository

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

    override suspend fun getNotes(): Flow<Resource<List<Notes>>> = flow{
        val status = notesAPI.getNotes().code()
        try{
            val notesList = notesAPI.getNotes().body()
            if(status == 200){
                emit(Resource.Success(notesList!!))
            }else{
                emit(Resource.Error("Unable to get notes!"))
            }
        }
        catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        } catch (e: HttpException) {
            emit(Resource.Error("An unexpected error occurred."))
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
}