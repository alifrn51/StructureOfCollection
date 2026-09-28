package org.example.calculator

class SimpleCalculator : Calculator{
    override fun sum(a: Int, b: Int): Int = a + b
    override fun multiplication(a: Int,b: Int) = a * b
    override fun division(a: Float,b: Float) = a / b
    override fun subtraction(a: Int,b: Int) = a - b
}