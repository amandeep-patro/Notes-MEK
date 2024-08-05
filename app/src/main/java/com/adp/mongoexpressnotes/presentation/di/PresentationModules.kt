package com.adp.mongoexpressnotes.presentation.di

import com.adp.mongoexpressnotes.presentation.add_notes.ViewModelAddNoteScreen
import com.adp.mongoexpressnotes.presentation.home.ViewModelHome
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module{
    viewModel{
        ViewModelAddNoteScreen()
    }
    viewModel{
        ViewModelHome()
    }
}