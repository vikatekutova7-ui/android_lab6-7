package com.tekutova.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat
import java.util.*

class TipCalculatorTests {
    @Test
    fun calculateTip_20PercentNoRound() {
        val amount = 10.0
        val tipPercent = 20.0
        val expectedTip = NumberFormat.getCurrencyInstance().format(2.0)
        val actualTip = calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_15PercentRoundUp() {
        val amount = 10.0
        val tipPercent = 15.0
        val expectedTip = NumberFormat.getCurrencyInstance().format(2.0) // 1.5 округляется до 2
        val actualTip = calculateTip(amount, tipPercent, true)
        assertEquals(expectedTip, actualTip)
    }
}