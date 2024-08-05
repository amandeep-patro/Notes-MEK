package com.adp.mongoexpressnotes.presentation.add_notes

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.adp.mongoexpressnotes.R
import com.adp.mongoexpressnotes.common.components.AppOutlinedTextField
import com.adp.mongoexpressnotes.common.components.AppToolBar
import com.adp.mongoexpressnotes.domain.models.Notes
import com.adp.mongoexpressnotes.presentation.add_notes.component.CustomFilterChip
import com.adp.mongoexpressnotes.presentation.navhost.HomeScreen

@Composable
fun AddNoteScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    state : StateAddNoteScreen,
    event : (EventAddNoteScreen) -> Unit
) {
    LaunchedEffect(state) {
        when{
            state.savingNotes -> {
                Log.d("NoteState", "Loading...")
            }
            state.notesSaved  == "Notes saved successfully!" -> {
                Log.d("NoteState", "Notes saved...")
                navController.navigate(HomeScreen) {
                    popUpTo(HomeScreen) {
                        inclusive = true
                    }
                }
            }
            state.notesError == "Unable to save notes!" -> {
                Log.d("NoteState", "Error...")
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            AppToolBar(title = "Add Note",
                navigationIcon = Icons.AutoMirrored.Default.ArrowBack,
                onNavigationClick = {
                    navController.navigate(HomeScreen) {
                        popUpTo(HomeScreen) {
                            inclusive = true
                        }
                    }
                }
            )

            Column(modifier = Modifier.padding(8.dp)){

                Spacer(modifier = Modifier.height(20.dp))

                AppOutlinedTextField(
                    value = state.notesTitle,
                    onValueChange = {title->
                        event(EventAddNoteScreen.AddNoteTitle(title))
                    },
                    maxLines = 2,
                    label = "Enter Note Title"
                )

                Spacer(modifier = Modifier.height(20.dp))

                AppOutlinedTextField(
                    value = state.notesDescription,
                    onValueChange = {desc->
                        event(EventAddNoteScreen.AddNoteDescription(desc))
                    },
                    maxLines = 5,
                    height = 300.dp,
                    label = "Enter Note Description"
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row (
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End)
                ){
                    CustomFilterChip(
                        label = "Low",
                        color = Color.Green,
                        selected = state.notesPriority == "Low",
                        onClick = {
                            event(EventAddNoteScreen.AddNotePriority("Low"))
                        },
                        alphaValue = 0.4f
                    )
                    CustomFilterChip(
                        label = "Medium",
                        color = Color.Yellow,
                        selected = state.notesPriority == "Medium",
                        onClick = {
                            event(EventAddNoteScreen.AddNotePriority("Medium"))
                        },
                        alphaValue = 0.4f
                    )
                    CustomFilterChip(
                        label = "High",
                        color = Color.Red,
                        selected = state.notesPriority == "High",
                        onClick = {
                            event(EventAddNoteScreen.AddNotePriority("High"))
                        },
                        alphaValue = 0.4f
                    )
                }
            }
        }
        FloatingActionButton(
            onClick = { //save note
//                      Log.d("NotesDetails", " ${state.notesTitle}, ${state.notesDescription}, ${state.notesPriority}")
                      val notes = Notes(
                          noteTitle = state.notesTitle,
                          noteDescription = state.notesDescription,
                          notePriority = state.notesPriority

                      )
                event(EventAddNoteScreen.SaveNote(notes))
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
            containerColor = Color.Transparent
        ) {
            val colorList = listOf(
//                    colorResource(id = R.color.a), // #000000
//                    colorResource(id = R.color.b), // #080808
//                    colorResource(id = R.color.c), // #101010
//                    colorResource(id = R.color.d), // #181818
//                    colorResource(id = R.color.e), // #202020
//                    colorResource(id = R.color.f), // #282828
//                    colorResource(id = R.color.g), // #303030
//                    colorResource(id = R.color.h), // #383838
//                    colorResource(id = R.color.i), // #404040
//                    colorResource(id = R.color.j), // #484848
//                    colorResource(id = R.color.k), // #505050
                    colorResource(id = R.color.l), // #585858
                    colorResource(id = R.color.m), // #606060
                    colorResource(id = R.color.n), // #686868
                    colorResource(id = R.color.o), // #707070
                    colorResource(id = R.color.p), // #787878
                    colorResource(id = R.color.q), // #808080
                    colorResource(id = R.color.r), // #888888
//                    colorResource(id = R.color.s), // #909090
//                    colorResource(id = R.color.t), // #989898
//                    colorResource(id = R.color.u), // #A0A0A0
//                    colorResource(id = R.color.v), // #A8A8A8
//                    colorResource(id = R.color.w), // #B0B0B0
//                    colorResource(id = R.color.x), // #B8B8B8
//                    colorResource(id = R.color.y), // #C0C0C0
//                    colorResource(id = R.color.z), // #C8C8C8
//                    colorResource(id = R.color.aa), // #D0D0D0
//                    colorResource(id = R.color.ab), // #D8D8D8
//                    colorResource(id = R.color.ac), // #E0E0E0
//                    colorResource(id = R.color.ad), // #E8E8E8
//                    colorResource(id = R.color.ae), // #F0F0F0
//                    colorResource(id = R.color.af), // #F8F8F8
//                    colorResource(id = R.color.ag)  // #FFFFFF
                )
            Box(modifier = Modifier
                .background(
                    brush = Brush.linearGradient(colorList),
                    shape = CircleShape
                )
                .padding(16.dp)
            ) {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = "Add",
                    tint = colorResource(id = R.color.e)
                )
            }
        }

    }
}