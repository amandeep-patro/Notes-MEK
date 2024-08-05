package com.adp.mongoexpressnotes.presentation.home

import com.adp.mongoexpressnotes.domain.models.Notes

sealed class EventHomeScreen {
    data class DeleteNote(val title : String): EventHomeScreen()
    data class AddNoteDescription(val description : String): EventHomeScreen()
    data class AddNotePriority(val priority : String): EventHomeScreen()
    data class SaveNote(val notes : Notes) : EventHomeScreen()
}