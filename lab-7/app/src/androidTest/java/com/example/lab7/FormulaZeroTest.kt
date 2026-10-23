
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
class FormulaZeroTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // Navigate to Upcoming Races
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // Verify the race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // Enter a location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // Add the location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // Check that Canada appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // Return Home
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // Verify the Home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
