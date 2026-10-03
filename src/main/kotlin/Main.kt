package org.example

import org.example.collections.NumberHashSet
import kotlin.random.Random

fun main() {

    val numbers = NumberHashSet()
    repeat(10){
        numbers.add(Random.nextInt(70,1000))
    }

    numbers.elements.forEach(::println)

    while (true){

        print("ENter: ")
        val num = readln().toInt()

        println("Contains: ${numbers.remove(num)}")

        numbers.elements.forEach(::println)
    }
}