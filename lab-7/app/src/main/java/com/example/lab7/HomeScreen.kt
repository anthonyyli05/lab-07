package com.example.lab7



import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


import androidx.compose.ui.platform.testTag


@Composable

fun HomeScreen(
    onUpcomingRacesClick: () -> Unit,
    onDriversClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "FormulaZero Home")

        Spacer(modifier = Modifier.height(24.dp))


        Button(
            onClick = onUpcomingRacesClick,
            modifier = Modifier.testTag("raceButton")
        ) {
            Text(text = "Upcoming Races")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onDriversClick,
            modifier = Modifier.testTag("driversButton")
        ) {
            Text(text = "Drivers")
        }


    }
}
