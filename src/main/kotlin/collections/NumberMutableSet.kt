package org.example.collections

interface NumberMutableSet {
    val size: Int
    fun add(number: Int): Boolean
    fun remove(number: Int)
    fun clear()
    fun contains(number: Int): Boolean
}