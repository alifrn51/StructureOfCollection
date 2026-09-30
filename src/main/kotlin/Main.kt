package org.example

import org.example.collections.NumberArrayList
import org.example.collections.NumberMutableList
import kotlin.time.measureTime

fun main() {

    val list: NumberMutableList = NumberArrayList()

    val time = measureTime {
        repeat(100_000_000){
            list.add(it)
        }
    }

    println(time)

}