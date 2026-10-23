package com.example.lab7

import androidx.compose.ui.platform.testTag

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UpcomingRacesScreen(onBackClick: () -> Unit) {
    var raceName by remember { mutableStateOf("") }
    val races = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Upcoming Races",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = raceName,
            onValueChange = { raceName = it },
            label = { Text("Race Location") },
            modifier = Modifier.testTag("locationInput")
        )


        Spacer(modifier = Modifier.height(8.dp))


        Button(
            onClick = {
                if (raceName.isNotBlank()) {
                    races.add(raceName.trim())
                    raceName = ""
                }
            },
            modifier = Modifier.testTag("addRaceButton")
        ) {
            Text("Add Race")
        }


        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(races) { race ->
                Text(
                    text = race,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }


        Button(
            onClick = onBackClick,
            modifier = Modifier.testTag("backButton")
        ) {
            Text("Back to Home")
        }

    }
}
