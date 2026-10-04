package org.example.collections

import kotlin.random.Random

fun main() {

    val numbers = MyHashSet<Item>()
    repeat(10){
        numbers.add(Item(Random.nextInt(70,1000)))
    }

    numbers.forEach(::println)

    while (true){
        print("Enter: ")
        val num = readln().toInt()
        println("Contains: ${numbers.remove(Item(num))}")
        numbers.forEach(::println)
    }
}