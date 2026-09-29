package org.example.collections

interface NumberMutableList {
    val size: Int
    fun add(number: Int)
    fun get(index: Int): Int
    fun removeAt(index: Int)
}