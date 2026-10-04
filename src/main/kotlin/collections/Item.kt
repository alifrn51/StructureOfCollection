package org.example.collections

data class Item(val value: Int): Comparable<Item> {
    override fun compareTo(other: Item): Int {
        return when{
            value > other.value -> 1
            value < other.value -> -1
            else -> 0
        }
    }
}