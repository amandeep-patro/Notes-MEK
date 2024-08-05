package com.adp.mongoexpressnotes.domain.models

data class Notes(
    val noteTitle : String,
    val noteDescription: String,
    val notePriority: String,
    val date: String ? = null
)

val notesList = listOf(
    Notes(
        noteTitle = "Grocery Shopping",
        noteDescription = "Buy milk, eggs, bread, and fruits.",
        notePriority = "High",
        date = "2024-08-04"
    ),
    Notes(
        noteTitle = "Study Schedule",
        noteDescription = "Study for upcoming exams: Maths, Physics, and Computer Science.",
        notePriority = "Medium",
        date = "2024-08-05"
    ),
    Notes(
        noteTitle = "Workout Plan",
        noteDescription = "Morning workout: running and strength training.",
        notePriority = "Low",
        date = "2024-08-06"
    ),
    Notes(
        noteTitle = "Project Meeting",
        noteDescription = "Attend the project meeting with the team at 3 PM.",
        notePriority = "High",
        date = "2024-08-07"
    ),
    Notes(
        noteTitle = "Call Parents",
        noteDescription = "Call parents to check on their health and well-being.",
        notePriority = "Medium",
        date = "2024-08-08"
    )
)