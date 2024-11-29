package com.paveltinnik.habridealapp.core.ui_kit

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JustNotesTopBar(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    titleContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    title: String
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { Text(title) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            titleContentColor = titleContentColor,
            containerColor = containerColor
        )
    )
}
