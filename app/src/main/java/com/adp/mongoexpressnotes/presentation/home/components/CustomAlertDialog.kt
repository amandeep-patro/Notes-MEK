package com.adp.mongoexpressnotes.presentation.home.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adp.mongoexpressnotes.R

@Composable
fun CustomAlertDialog(
    onDismissRequest: () -> Unit,
    title: String,
    text: String,
    confirmButtonText: String,
    dismissButtonText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(title, color = colorResource(id = R.color.y), fontWeight = FontWeight.Bold) },
        text = { Text(text, color = colorResource(id = R.color.u)) },
        confirmButton = {
            Button(
                onClick = onConfirmClick,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.r))
            ) {
                Text(confirmButtonText, color = colorResource(id = R.color.d), fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            Button(
                onClick = onDismissClick,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.r))
            ) {
                Text(dismissButtonText, color = colorResource(id = R.color.d), fontWeight = FontWeight.Bold)
            }
        },
    )
}
