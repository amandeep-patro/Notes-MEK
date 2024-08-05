package com.adp.mongoexpressnotes.data.remote

import com.adp.mongoexpressnotes.domain.models.Notes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NotesAPI {

    @POST("/save-notes")
    suspend fun saveNotes(@Body notes: Notes) : Response<Notes>

    @GET("/notes")
    suspend fun getNotes() : Response<List<Notes>>

    @DELETE("/notes/{id}")
    suspend fun deleteNoteById(@Path("id") id: String) : Response<Void>
}