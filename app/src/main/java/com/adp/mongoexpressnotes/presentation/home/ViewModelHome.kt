package com.adp.mongoexpressnotes.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adp.mongoexpressnotes.common.util.Resource
import com.adp.mongoexpressnotes.domain.models.Notes
import com.adp.mongoexpressnotes.domain.repository.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ViewModelHome : ViewModel(), KoinComponent {
    private val notesRepository : NotesRepository by inject()

    private val _getNotesState = MutableStateFlow(StateHomeScreen())
    val getNotesState = _getNotesState

    init{
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            notesRepository.getNotes().collect {resource ->
                when(resource){
                    is Resource.Success -> {
                        _getNotesState.value = getNotesState.value.copy(fetchedNotes = resource.data, gettingNotes = false)
                    }
                    is Resource.Loading -> {
                        _getNotesState.value = getNotesState.value.copy(gettingNotes = true)
                    }
                    is Resource.Error -> {
                        _getNotesState.value = getNotesState.value.copy(error = resource.message, gettingNotes = false)
                    }
                }
            }
        }
    }

    private fun deleteNoteById(id: String) {
        viewModelScope.launch {
            notesRepository.deleteNoteById(id).collect{resource->
                when(resource){
                    is Resource.Loading -> {
                        _getNotesState.value = getNotesState.value.copy(deletingNote = true)
                    }
                    is Resource.Success -> {
                        _getNotesState.value = getNotesState.value.copy(noteDeleted = resource.data.toString(), deletingNote = false)
                        getNotes()
                    }
                    is Resource.Error -> {
                        _getNotesState.value = getNotesState.value.copy(deleteError = resource.message.toString(), deletingNote = false)
                    }
                }
            }
        }
    }

    private fun updateNoteById(id: String, notes: Notes) {
        viewModelScope.launch {
            notesRepository.updateNoteById(id, notes).collect { resource ->
                when(resource) {
                    is Resource.Loading -> {
                        _getNotesState.value = getNotesState.value.copy(updatingNote = true)
                    }
                    is Resource.Success -> {
                        _getNotesState.value = getNotesState.value.copy(noteUpdated = resource.data, updatingNote = false)
                        getNotes()
                    }
                    is Resource.Error -> {
                        _getNotesState.value = getNotesState.value.copy(updateError = resource.message, updatingNote = false)
                    }
                }
            }
        }
    }

    fun onEvent(event: EventHomeScreen){
        when(event){
            is EventHomeScreen.DeleteNote -> {
                deleteNoteById(event.id)
            }
            is EventHomeScreen.UpdateNote -> {
                updateNoteById(event.id, event.notes)
            }
        }

    }
}