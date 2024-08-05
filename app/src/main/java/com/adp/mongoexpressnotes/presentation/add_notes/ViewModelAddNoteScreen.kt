package com.adp.mongoexpressnotes.presentation.add_notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adp.mongoexpressnotes.common.util.Resource
import com.adp.mongoexpressnotes.domain.models.Notes
import com.adp.mongoexpressnotes.domain.repository.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ViewModelAddNoteScreen : ViewModel() , KoinComponent{

    private val notesRepository : NotesRepository by inject()

    private val _stateNote = MutableStateFlow(StateAddNoteScreen())
    val notesState = _stateNote

    private fun saveNotes(notes: Notes){
        viewModelScope.launch {
            notesRepository.saveNotes(notes).collect{resource ->
                when(resource){
                    is Resource.Loading ->{
                        _stateNote.value = notesState.value.copy(savingNotes = true)
                    }
                    is Resource.Success ->{
                        _stateNote.value = notesState.value.copy(notesSaved = resource.data.toString(), savingNotes = false)
                    }
                    is Resource.Error -> {
                        _stateNote.value = notesState.value.copy(notesError = resource.message.toString(), savingNotes = false)
                    }
                }
            }

        }
    }

    fun onEvent(event: EventAddNoteScreen){
        when(event){
            is EventAddNoteScreen.AddNoteTitle ->{
                _stateNote.value = _stateNote.value.copy(
                    notesTitle = event.title
                )
            }
            is EventAddNoteScreen.AddNoteDescription ->{
                _stateNote.value = _stateNote.value.copy(
                    notesDescription = event.description
                )
            }
            is EventAddNoteScreen.AddNotePriority ->{
                _stateNote.value = _stateNote.value.copy(
                    notesPriority = event.priority
                )
            }

            is EventAddNoteScreen.SaveNote -> {
                saveNotes(event.notes)
            }
        }
    }
}