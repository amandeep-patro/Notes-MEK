package com.adp.mongoexpressnotes.common.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.adp.mongoexpressnotes.R
import com.adp.mongoexpressnotes.common.components.AppToolBar
import com.adp.mongoexpressnotes.presentation.navhost.AddNoteScreen

@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: ImageVector? = null,
    onNavigationClick: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = title, color = colorResource(id = R.color.z)) },
        colors = TopAppBarDefaults.topAppBarColors ()
            .copy(
                containerColor = Color.Transparent
            ),
        navigationIcon = {
            if (navigationIcon != null) {
                IconButton (onClick = onNavigationClick) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = "Navigation Icon",
                        tint = Color.White
                    )
                }
            }
        },
        modifier = modifier
    )
}