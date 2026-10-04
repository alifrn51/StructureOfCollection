package org.example.collections

import kotlin.random.Random

fun main() {

    val number = myListOf<Int>(2,3)

    (number as MyMutableList<Int>).add(21)

    number.forEach(::println)

}