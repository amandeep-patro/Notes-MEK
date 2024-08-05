package com.adp.mongoexpressnotes.presentation.home

import com.adp.mongoexpressnotes.domain.models.Notes

sealed class EventHomeScreen {
    data class DeleteNote(val id : String): EventHomeScreen()
    data class UpdateNote(val id: String, val notes: Notes): EventHomeScreen()
}