package com.adp.mongoexpressnotes.presentation.navhost

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adp.mongoexpressnotes.presentation.home.HomeScreen
import com.adp.mongoexpressnotes.presentation.add_notes.AddNoteScreen
import com.adp.mongoexpressnotes.presentation.add_notes.ViewModelAddNoteScreen
import com.adp.mongoexpressnotes.presentation.home.ViewModelHome
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen>
        {
            val viewModel : ViewModelHome = koinViewModel()
            val state by viewModel.getNotesState.collectAsState()
            HomeScreen(
                navController = navController,
                state = state,
                event = { viewModel.onEvent(it) }
                )
        }
        composable<AddNoteScreen> {
            val viewModel : ViewModelAddNoteScreen = koinViewModel()
            val state by viewModel.notesState.collectAsState()
            AddNoteScreen(
                navController = navController,
                state = state,
                event = { viewModel.onEvent(it) }
            )
        }
    }
}