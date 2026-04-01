package com.tekutova.myapplication

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tekutova.myapplication.ui.theme.Tip_Time_ThemeTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.NumberFormat

@RunWith(AndroidJUnit4::class)
class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            Tip_Time_ThemeTheme {
                TipTimeLayout()
            }
        }

        composeTestRule
            .onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule
            .onNodeWithText("Tip Percentage")
            .performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2.0)
        composeTestRule
            .onNodeWithText("Tip Amount: $expectedTip")
            .assertExists()
    }
}