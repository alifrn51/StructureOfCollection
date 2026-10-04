package org.example.collections

import kotlin.random.Random

fun main() {

    val numbers = mutableSetOf<Item>()
    repeat(10){
        numbers.add(Item(Random.nextInt(70,1000)))
    }
    for (number in numbers){
        println(number)
    }

}