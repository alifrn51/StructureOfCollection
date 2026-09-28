package calculator

import org.example.calculator.Calculator
import org.example.calculator.LoggingCalculator
import org.example.calculator.SimpleCalculator
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class CalculatorTest {


    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 Plus 10 by Then Result 15`(calculator: Calculator) {
        val result = calculator.sum(5, 10)
        val expected = 15
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 50 Plus 100 by Then Result 150`(calculator: Calculator) {
        val result = calculator.sum(50, 100)
        val expected = 150
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 Mines 5 by Then Result 5`(calculator: Calculator){
        val result = calculator.subtraction(10, 5)
        val expected = 5
        assertEquals(expected,result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 Mines 10 by Then Result -5`(calculator: Calculator){
        val result = calculator.subtraction(5, 10)
        val expected = -5
        assertEquals(expected,result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 Is Multiplied 10 by Then Result 50`(calculator: Calculator){
        val result = calculator.multiplication(5, 10)
        val expected = 50
        assertEquals(expected,result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 4 Is Multiplied by 3 Then Result 12`(calculator: Calculator){
        val result = calculator.multiplication(4, 3)
        val expected = 12
        assertEquals(expected,result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 Is Divided by 10 Then Result 0,5f`(calculator: Calculator){
        val result = calculator.division(5f, 10f)
        val expected = 0.5f
        assertEquals(expected.toDouble(),result.toDouble(),0.001)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 0 Is Divided by 2 Then Result 0`(calculator: Calculator){
        val result = calculator.division(0f, 2f)
        val expected = 0f
        assertEquals(expected.toDouble(),result.toDouble(),0.001)
    }

    @Test
    fun testDouble() {
        var number = 0.0
        repeat(100) {
            number += 0.01
        }
        val expected = 1.0

        assertEquals(expected,number,0.001)
    }

    companion object{
        @JvmStatic
        fun calculatorsSource() = listOf(SimpleCalculator(), LoggingCalculator())
    }

}