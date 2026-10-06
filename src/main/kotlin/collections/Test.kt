package org.example.collections

import kotlin.random.Random

fun main() {

    val number = myListOf<Int>(2,3)
    var elements1 = mutableListOf<Int>()

    elements1.add(12)

    setA(elements1)

    (number as MyMutableList<Int>).add(21)

    number.forEach(::println)

}

fun setA (el: List<Int>){

}