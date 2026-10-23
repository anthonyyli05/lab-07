
package com.example.lab7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun DriversScreen(onBackClick: () -> Unit) {
    var driverName by remember { mutableStateOf("") }
    val drivers = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Drivers",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = driverName,
            onValueChange = { driverName = it },
            label = { Text("Driver Name") },
            modifier = Modifier.testTag("driverInput")
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (driverName.isNotBlank()) {
                    drivers.add(driverName.trim())
                    driverName = ""
                }
            },
            modifier = Modifier.testTag("addDriverButton")
        ) {
            Text("Add Driver")
        }

        Button(
            onClick = { drivers.clear() },
            modifier = Modifier.testTag("clearDriversButton")
        ) {
            Text("Clear Drivers")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(drivers) { driver ->
                Text(
                    text = driver,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier.testTag("driversBackButton")
        ) {
            Text("Back to Home")
        }
    }
}
