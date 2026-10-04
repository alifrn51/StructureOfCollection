package org.example.collections

interface MyMutableList<T>: MyMutableCollection<T> , MyList<T> {
    override val size: Int
    override fun add(element: T): Boolean
    operator fun plus(element: T)
    fun add(index: Int, element: T)
    override operator fun get(index: Int): T
    fun removeAt(index: Int)
    operator fun minus(index: Int)
    override fun remove(element: T)
    override fun clear()
    override fun contains(element: T): Boolean
}