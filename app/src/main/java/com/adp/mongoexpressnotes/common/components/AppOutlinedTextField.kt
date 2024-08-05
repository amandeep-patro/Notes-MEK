package com.adp.mongoexpressnotes.common.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adp.mongoexpressnotes.R

@Composable
fun AppOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    maxLines: Int = 1,
    height: Dp = 60.dp,
    label: String
) {
    val colorList = listOf(
//        colorResource(id = R.color.ag), // #FFFFFF
//        colorResource(id = R.color.af), // #F8F8F8
//        colorResource(id = R.color.ae), // #F0F0F0
//        colorResource(id = R.color.ad), // #E8E8E8
//        colorResource(id = R.color.ac), // #E0E0E0
//        colorResource(id = R.color.ab), // #D8D8D8
//        colorResource(id = R.color.aa), // #D0D0D0
//        colorResource(id = R.color.z), // #C8C8C8
//        colorResource(id = R.color.y), // #C0C0C0
//        colorResource(id = R.color.x), // #B8B8B8
//        colorResource(id = R.color.w), // #B0B0B0
//        colorResource(id = R.color.v), // #A8A8A8
//        colorResource(id = R.color.u), // #A0A0A0
//        colorResource(id = R.color.t), // #989898
//        colorResource(id = R.color.s), // #909090
//        colorResource(id = R.color.r), // #888888
//        colorResource(id = R.color.q), // #808080
//        colorResource(id = R.color.p), // #787878
//        colorResource(id = R.color.o), // #707070
//        colorResource(id = R.color.n), // #686868
//        colorResource(id = R.color.m), // #606060
//        colorResource(id = R.color.l), // #585858
//        colorResource(id = R.color.k), // #505050
//        colorResource(id = R.color.j), // #484848
//        colorResource(id = R.color.i), // #404040
        colorResource(id = R.color.h), // #383838
        colorResource(id = R.color.g), // #303030
        colorResource(id = R.color.f), // #282828
        colorResource(id = R.color.e), // #202020
        colorResource(id = R.color.d), // #181818
        colorResource(id = R.color.c), // #101010
//        colorResource(id = R.color.b), // #080808
//        colorResource(id = R.color.a)  // #000000
    )

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(
                brush = Brush.verticalGradient(colors = colorList),
                shape = RoundedCornerShape(5.dp)
            )
            .then(modifier),
        value = value,
        label = { Text(text = label) },
        onValueChange = { onValueChange(it) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedTextColor = colorResource(id = R.color.white),
            unfocusedTextColor = colorResource(id = R.color.white),
            focusedContainerColor = Color.Transparent, // Transparent to show brush background
            unfocusedContainerColor = Color.Transparent, // Transparent to show brush background
        ),
        maxLines = maxLines,
        shape = RoundedCornerShape(5.dp)
    )
}
