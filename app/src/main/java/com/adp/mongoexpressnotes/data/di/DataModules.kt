package com.adp.mongoexpressnotes.data.di

import com.adp.mongoexpressnotes.data.remote.NotesAPI
import com.adp.mongoexpressnotes.data.repository.NotesRepositoryImpl
import com.adp.mongoexpressnotes.domain.repository.NotesRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideNotesApi() : NotesAPI{
    return Retrofit.Builder()
        .baseUrl("http://192.168.113.254:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NotesAPI::class.java)
}

fun provideNotesRepository(notesAPI : NotesAPI): NotesRepository{
    return NotesRepositoryImpl(notesAPI)
}
val dataModules = module{
    single{
        provideNotesApi()
    }
    single{
        provideNotesRepository(get())
    }
}