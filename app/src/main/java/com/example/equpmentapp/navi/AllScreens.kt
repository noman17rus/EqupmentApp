package com.example.equpmentapp.navi

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.equpmentapp.EViewModel
import com.example.equpmentapp.ui.theme.DetailInfoScreen
import com.example.equpmentapp.ui.theme.HomeScreen

sealed class AllScreens(val route: String) {
    object HomeScreen : AllScreens("Screen1")
    object DetailInfoScreen : AllScreens("Screen2")
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ENavHost(navigator: NavHostController, viewModel: EViewModel) {


    NavHost(navController = navigator, startDestination = AllScreens.HomeScreen.route) {
        composable(AllScreens.HomeScreen.route) { HomeScreen(navigator = navigator) }
        composable(AllScreens.DetailInfoScreen.route) {
            DetailInfoScreen(
                navigator = navigator,
                viewModel = viewModel
            )
        }
    }
}