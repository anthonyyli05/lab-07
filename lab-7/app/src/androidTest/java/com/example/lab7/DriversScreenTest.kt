
package com.example.lab7


import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun add_clear_drivers_and_return_home() {
        // Open Drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // Add first driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // Add second driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Max Verstappen")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // Verify both drivers appear
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertExists()

        // Clear all drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // Verify both were removed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertDoesNotExist()

        // Return Home
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
