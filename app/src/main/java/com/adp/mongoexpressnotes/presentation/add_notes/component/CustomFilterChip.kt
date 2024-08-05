package com.adp.mongoexpressnotes.presentation.add_notes.component


import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adp.mongoexpressnotes.R

@Composable
fun CustomFilterChip(
    label: String,
    color: Color,
    selected: Boolean,
    alphaValue: Float = 0.2f,
    onClick: () -> Unit
){
    val chipColor = when (label.lowercase()) {
        "low" -> colorResource(id = R.color.green1)
        "medium" -> colorResource(id = R.color.yellow1)
        "high" -> colorResource(id = R.color.red1)
        else -> Color.Transparent
    }
    val colorList = listOf(
        colorResource(id = R.color.a), // #000000
        colorResource(id = R.color.h), // #383838
        colorResource(id = R.color.g), // #303030
        colorResource(id = R.color.f), // #282828
        colorResource(id = R.color.e), // #202020
        colorResource(id = R.color.d), // #181818
    )
    FilterChip(
        modifier = Modifier.alpha(0.6f),
        onClick= onClick,
        label = {
            Text(
                text = label,
                color = colorResource(id = R.color.a),
                fontWeight = FontWeight.W900
            )
        },
        selected = selected,
        leadingIcon = if (selected) {
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
            containerColor = chipColor,
            labelColor = colorResource(id = R.color.a),
            leadingIconColor = colorResource(id = R.color.a),
            selectedContainerColor = chipColor,
        ),
        border = null
    )
}