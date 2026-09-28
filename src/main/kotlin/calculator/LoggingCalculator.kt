package org.example.calculator

class LoggingCalculator : Calculator{

    override fun sum(a: Int, b: Int): Int {
        val result = a + b
        println("sum($a, $b) Result = $result")
        return result
    }

    override fun subtraction(a: Int, b: Int) : Int {
        val result = a - b
        println("subtraction($a, $b) Result = $result")
        return result
    }

    override fun multiplication(a: Int, b: Int) : Int {
        val result = a * b
        println("multiplication($a, $b) Result = $result")
        return result
    }

    override fun division(a: Float, b: Float) : Float {
        val result = a / b
        println("division($a, $b) Result = $result")
        return result
    }

}