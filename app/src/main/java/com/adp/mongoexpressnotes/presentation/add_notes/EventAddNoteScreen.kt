package com.adp.mongoexpressnotes.presentation.add_notes

import com.adp.mongoexpressnotes.domain.models.Notes

sealed class EventAddNoteScreen {
    data class AddNoteTitle(val title : String): EventAddNoteScreen()
    data class AddNoteDescription(val description : String): EventAddNoteScreen()
    data class AddNotePriority(val priority : String): EventAddNoteScreen()
    data class SaveNote(val notes : Notes) : EventAddNoteScreen()
}