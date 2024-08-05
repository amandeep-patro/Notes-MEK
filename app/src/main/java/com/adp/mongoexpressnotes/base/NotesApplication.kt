package com.adp.mongoexpressnotes.base

import android.app.Application
import com.adp.mongoexpressnotes.data.di.dataModules
import com.adp.mongoexpressnotes.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class NotesApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(
                presentationModule, dataModules
            )
            androidContext(this@NotesApplication)
        }
    }

}