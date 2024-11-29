package com.paveltinnik.habridealapp.create_and_update_note.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paveltinnik.habridealapp.create_and_update_note.presentation.CreateAndUpdateNoteRoute
import com.paveltinnik.habridealapp.R

const val CREATE_AND_UPDATE_NOTE_ROUTE = "create_and_update_note_route"
const val NOTE_ID_ARG = "note_id"
const val TOP_BAR_TITLE_ARG = "top_bar_title"

enum class CreateAndUpdateNoteResArg {
    CREATE_NOTE, UPDATE_NOTE
}

fun NavController.navigateToCreateAndUpdateNote(
    topBarTitleResArg: CreateAndUpdateNoteResArg,
    noteId: String?
) {
    val topBarTitleResId = when(topBarTitleResArg) {
        CreateAndUpdateNoteResArg.CREATE_NOTE -> R.string.create_note_topbar_title
        CreateAndUpdateNoteResArg.UPDATE_NOTE -> R.string.update_note_topbar_title
    }
    navigate(
        route = "$CREATE_AND_UPDATE_NOTE_ROUTE/$topBarTitleResId/$noteId",
    ) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.createAndUpdateNoteScreen(navigateToHomeScreen: () -> Unit) {
    composable(
        route = "$CREATE_AND_UPDATE_NOTE_ROUTE/{$TOP_BAR_TITLE_ARG}/{$NOTE_ID_ARG}",
        arguments = listOf(
            navArgument(NOTE_ID_ARG) { type = NavType.StringType; nullable = true },
            navArgument(TOP_BAR_TITLE_ARG) { type = NavType.IntType }
        )
    ) { backStackEntry ->
        CreateAndUpdateNoteRoute(
            topBarTitle = backStackEntry.arguments?.getInt(TOP_BAR_TITLE_ARG),
            navigateToHomeScreen = navigateToHomeScreen
        )
    }
}
