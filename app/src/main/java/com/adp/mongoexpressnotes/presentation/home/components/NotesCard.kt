package com.adp.mongoexpressnotes.presentation.home.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adp.mongoexpressnotes.R
import com.adp.mongoexpressnotes.domain.models.Notes
import com.adp.mongoexpressnotes.presentation.add_notes.component.CustomFilterChip
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesCard(
    modifier: Modifier = Modifier,
    notes: Notes
){
    val chipColor = remember(notes.notePriority){
        when(notes.notePriority){
            "Medium" -> Color.Yellow
            "High" -> Color.Red
            else -> Color.Green

        }
    }

    val colorList = listOf(
//                    colorResource(id = R.color.a), // #000000
//                    colorResource(id = R.color.b), // #080808
//                    colorResource(id = R.color.c), // #101010
                    colorResource(id = R.color.d), // #181818
                    colorResource(id = R.color.e), // #202020
                    colorResource(id = R.color.f), // #282828
                    colorResource(id = R.color.g), // #303030
                    colorResource(id = R.color.h), // #383838
                    colorResource(id = R.color.i), // #404040
                    colorResource(id = R.color.j), // #484848
//                    colorResource(id = R.color.k), // #505050
//                    colorResource(id = R.color.l), // #585858
//                    colorResource(id = R.color.m), // #606060
//                    colorResource(id = R.color.n), // #686868
//                    colorResource(id = R.color.o), // #707070
//                    colorResource(id = R.color.p), // #787878
//                    colorResource(id = R.color.q), // #808080
//                    colorResource(id = R.color.r), // #888888
//                    colorResource(id = R.color.s), // #909090
//                    colorResource(id = R.color.t), // #989898
//                    colorResource(id = R.color.u), // #A0A0A0
//                    colorResource(id = R.color.v), // #A8A8A8
//                    colorResource(id = R.color.w), // #B0B0B0
//                    colorResource(id = R.color.x), // #B8B8B8
//                    colorResource(id = R.color.y), // #C0C0C0
//                    colorResource(id = R.color.z), // #C8C8C8
//                    colorResource(id = R.color.aa), // #D0D0D0
//                    colorResource(id = R.color.ab), // #D8D8D8
//                    colorResource(id = R.color.ac), // #E0E0E0
//                    colorResource(id = R.color.ad), // #E8E8E8
//                    colorResource(id = R.color.ae), // #F0F0F0
//                    colorResource(id = R.color.af), // #F8F8F8
//                    colorResource(id = R.color.ag)  // #FFFFFF
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(colorList))
    ){
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            modifier = modifier.fillMaxWidth()
        ){
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Brush.linearGradient(colorList))){
                Column(modifier = Modifier.padding(8.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){
//                        CustomFilterChip(
//                            label = notes.notePriority,
//                            color = chipColor,
//                            selected = false,
//                            alphaValue = 0.4f
//                        ){}
                        NotePriorityCircle(chipColor = notes.notePriority)
                    }
                    Text(
                        text = notes.noteTitle,
                        color = colorResource(id = R.color.text1),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Text(
                        text = notes.noteDescription,
                        color = colorResource(id = R.color.text2),
                        fontSize = 15.sp,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.padding(12.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = formatTimestampToDDMMYYYY(notes.date!!),
                        color = colorResource(id = R.color.text3),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatTimestampToDDMMYYYY (timestamp: String): String {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val zonedDateTime = ZonedDateTime.parse(timestamp, formatter)
// Convert to IST (Indian Standard Time) which is UTC+5:30
    val zoneId = ZoneId.of (  "Asia/Kolkata")
    val istDateTime = zonedDateTime.withZoneSameInstant(zoneId)
// Format day, month, and year
    val day = istDateTime.dayOfMonth.toString().padStart (2,'0')
    val month = istDateTime.monthValue.toString().padStart (2, '0')
    val year = istDateTime.year.toString()
    return "$day-$month-$year"
}

@Composable
fun NotePriorityCircle(chipColor: String) {
    
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Box(
            modifier = Modifier
                .size(17.dp)
                .background(
                    color = when (chipColor) {
                        "Low" -> colorResource(id = R.color.green1)
                        "Medium" -> colorResource(id = R.color.yellow1)
                        "High" -> colorResource(id = R.color.red1)
                        else -> colorResource(id = R.color.teal_200)
                    },
                    shape = CircleShape
                )
        )
    }
}