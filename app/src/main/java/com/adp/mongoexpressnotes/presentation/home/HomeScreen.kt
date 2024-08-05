package com.adp.mongoexpressnotes.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.adp.mongoexpressnotes.R
import com.adp.mongoexpressnotes.common.components.AppToolBar
import com.adp.mongoexpressnotes.domain.models.notesList
import com.adp.mongoexpressnotes.presentation.home.components.NotesCard
import com.adp.mongoexpressnotes.presentation.navhost.AddNoteScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navController: NavHostController,
    state: StateHomeScreen,
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            AppToolBar(title = "Notes",)

            if(ifNotesFetched(state)){
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalItemSpacing = 10.dp
                ) {
                    items(state.fetchedNotes!!){
                        NotesCard(notes = it)
                    }
                }
            }


        }
        FloatingActionButton(
            onClick={
                navController.navigate(AddNoteScreen)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
            containerColor = Color.Transparent
        ) {
            val colorList = listOf(
//                    colorResource(id = R.color.a), // #000000
                colorResource(id = R.color.h), // #383838
                colorResource(id = R.color.g), // #303030
                colorResource(id = R.color.f), // #282828
                colorResource(id = R.color.e), // #202020
                colorResource(id = R.color.d), // #181818
            )
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.radialGradient(colorList),
                        shape = CircleShape
                    )
                    .padding(16.dp)
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Add",
                    tint = colorResource(id = R.color.v)
                )
            }
        }
    }
}

fun ifNotesFetched(state: StateHomeScreen): Boolean {
    return when{
        state.gettingNotes -> false
        state.fetchedNotes!!.isNotEmpty() ->true
        else -> {false}
    }
}
