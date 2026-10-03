package org.example.collections

interface MyMutableList<T> {
    val size: Int
    fun add(element: T)
    operator fun plus(element: T)
    fun add(index: Int, element: T)
    operator fun get(index: Int): T
    fun removeAt(index: Int)
    operator fun minus(index: Int)
    fun remove(element: T)
    fun clear()
    fun contains(element: T): Boolean
}