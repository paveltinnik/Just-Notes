package com.paveltinnik.habridealapp.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.paveltinnik.habridealapp.home.presentation.HomeScreenRoute

const val HOME_SCREEN_ROUTE = "home_screen"

fun NavController.navigateToHomeScreen() = navigate(HOME_SCREEN_ROUTE) {
    popUpTo(HOME_SCREEN_ROUTE) {
        inclusive = true
    }
}

fun NavGraphBuilder.homeScreen(
    navigateToCreateNoteScreen: () -> Unit,
    navigateToUpdateNote: (String) -> Unit
) {
    composable(route = HOME_SCREEN_ROUTE) {
        HomeScreenRoute(
            navigateToCreateNoteScreen = navigateToCreateNoteScreen,
            navigateToUpdateNote = navigateToUpdateNote
        )
    }
}