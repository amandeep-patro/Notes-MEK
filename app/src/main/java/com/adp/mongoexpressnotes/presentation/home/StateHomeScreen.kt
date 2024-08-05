package com.adp.mongoexpressnotes.presentation.home

import com.adp.mongoexpressnotes.domain.models.Notes

data class StateHomeScreen (
    val gettingNotes : Boolean = false,
    val fetchedNotes : List<Notes> ?= emptyList(),
    val error : String = ""
)