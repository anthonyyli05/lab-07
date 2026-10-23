package com.example.lab7


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun FormulaZeroApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onUpcomingRacesClick = {
                    navController.navigate("upcoming_races")
                },
                onDriversClick = {
                    navController.navigate("drivers")
                }
            )
        }

        composable("upcoming_races") {
            UpcomingRacesScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable("drivers") {
            DriversScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
