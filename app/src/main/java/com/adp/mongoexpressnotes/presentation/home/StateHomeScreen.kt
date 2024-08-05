package com.adp.mongoexpressnotes.presentation.home

import com.adp.mongoexpressnotes.domain.models.Notes

data class StateHomeScreen (
    val gettingNotes : Boolean = false,
    val fetchedNotes : List<Notes> ?= emptyList(),
    val error : String = "",

    val deletingNote : Boolean = false,
    val noteDeleted : String = "",
    val deleteError : String = "",

    val updatingNote: Boolean = false,
    val noteUpdated: Notes? = null,
    val updateError: String = ""
)