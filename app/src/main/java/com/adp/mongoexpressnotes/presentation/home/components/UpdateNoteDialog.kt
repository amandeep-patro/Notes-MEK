package com.adp.mongoexpressnotes.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adp.mongoexpressnotes.R
import com.adp.mongoexpressnotes.domain.models.Notes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChipDefaults


@Composable
fun UpdateNoteDialog(
    initialNote: Notes,
    onDismissRequest: () -> Unit,
    onConfirmClick: (Notes) -> Unit
) {
    var title by rememberSaveable { mutableStateOf(initialNote.noteTitle) }
    var description by rememberSaveable { mutableStateOf(initialNote.noteDescription) }
    var priority by rememberSaveable { mutableStateOf(initialNote.notePriority) }


    AlertDialog(
        modifier = Modifier.wrapContentSize(),
        onDismissRequest = onDismissRequest,
        title = { Text(text = "Update Note", color = colorResource(id = R.color.y), fontWeight = FontWeight.Bold) },
        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") }
                )
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End)
                ){
                    FilterChip(
                        modifier = Modifier.alpha(0.6f),
                        onClick= { priority = "Low"},
                        label = {
                            Text(
                                text = "Low",
                                color = colorResource(id = R.color.a),
                                fontWeight = FontWeight.W900
                            )
                        },
                        selected = ("Low" == priority),
                        leadingIcon = if ("Low" == priority) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    tint = colorResource(id = R.color.a),
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        },
                        colors = FilterChipDefaults.filterChipColors().copy(
                            containerColor = colorResource(id = R.color.green1),
                            labelColor = colorResource(id = R.color.a),
                            leadingIconColor = colorResource(id = R.color.a),
                            selectedContainerColor = colorResource(id = R.color.green1),
                        ),
                        border = null
                    )

                    FilterChip(
                        modifier = Modifier.alpha(0.6f),
                        onClick= { priority = "Medium"},
                        label = {
                            Text(
                                text = "Medium",
                                color = colorResource(id = R.color.a),
                                fontWeight = FontWeight.W900
                            )
                        },
                        selected = ("Medium" == priority),
                        leadingIcon = if ("Medium" == priority) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    tint = colorResource(id = R.color.a),
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        },
                        colors = FilterChipDefaults.filterChipColors().copy(
                            containerColor = colorResource(id = R.color.yellow1),
                            labelColor = colorResource(id = R.color.a),
                            leadingIconColor = colorResource(id = R.color.a),
                            selectedContainerColor = colorResource(id = R.color.yellow1),
                        ),
                        border = null
                    )

                    FilterChip(
                        modifier = Modifier.alpha(0.6f),
                        onClick= { priority = "High"},
                        label = {
                            Text(
                                text = "High",
                                color = colorResource(id = R.color.a),
                                fontWeight = FontWeight.W900
                            )
                        },
                        selected = ("High" == priority),
                        leadingIcon = if ("High" == priority) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    tint = colorResource(id = R.color.a),
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        },
                        colors = FilterChipDefaults.filterChipColors().copy(
                            containerColor = colorResource(id = R.color.red1),
                            labelColor = colorResource(id = R.color.a),
                            leadingIconColor = colorResource(id = R.color.a),
                            selectedContainerColor = colorResource(id = R.color.red1),
                        ),
                        border = null
                    )
                }
            }
        },
        confirmButton = {
            Button(onClick = {
                val updatedNote = initialNote.copy(
                    noteTitle = title,
                    noteDescription = description,
                    notePriority = priority
                )
                onConfirmClick(updatedNote)
            },
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.r))
                ) {
                Text(text = "Update", color = colorResource(id = R.color.d), fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            Button(
                onClick = onDismissRequest,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.r))) {
                Text(text = "Cancel", color = colorResource(id = R.color.d), fontWeight = FontWeight.Bold)
            }
        }
    )
}
