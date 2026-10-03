package org.example

import org.example.collections.Item
import org.example.collections.MyHashSet
import kotlin.random.Random

fun main() {

    val numbers = MyHashSet<Item>()
    repeat(10){
        numbers.add(Item(Random.nextInt(70,1000)))
    }

    numbers.elements.forEach(::println)

    while (true){

        print("ENter: ")
        val num = readln().toInt()

        println("Contains: ${numbers.remove(Item(num))}")

        numbers.elements.forEach(::println)
    }
}