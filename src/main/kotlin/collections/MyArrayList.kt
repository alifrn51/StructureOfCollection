package org.example.collections

class MyArrayList<T> : MyMutableList<T> {

    private var elements = arrayOfNulls<Any>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    override fun add(element: T): Boolean {
        growUp()
        elements[size] = element
        size++
        return true
    }

    override fun plus(element: T) {
        add(element)
    }

    private fun growUp() {
        if (elements.size == size) {
            val newArray = arrayOfNulls<Any>(elements.size * 2)
            System.arraycopy(elements, 0, newArray, 0, size)
            elements = newArray
        }
    }

    override fun add(index: Int, element: T) {
        chackIndexOutOfBoundsForAdding(index)
        growUp()
        System.arraycopy(elements, index, elements, index + 1, size - index)
        elements[index] = element
        size++
    }

    override fun get(index: Int): T {
        chackIndexOutOfBounds(index)
        return this.elements[index] as T
    }

    override fun removeAt(index: Int) {
        chackIndexOutOfBounds(index)
        System.arraycopy(elements, index+1, elements, index, size - index -1)
        size--
        elements[size] = null
    }

    override fun minus(index: Int) {
        removeAt(index)
    }

    override fun remove(element: T) {
        for (index in 0 until size) {
            if (element == elements[index]) {
                removeAt(index)
            }
        }
    }

    override fun clear() {
        elements = arrayOfNulls(10)
        size = 0
    }

    override fun contains(element: T): Boolean {
        for (i in 0 until size) {
            if (element == elements[i]) {
                return true
            }
        }
        return false
    }

    private fun chackIndexOutOfBounds(index: Int) {
        if (index !in 0..<size) {
            throw IndexOutOfBoundsException("Exception Index: $index, Size: $size")
        }
    }

    private fun chackIndexOutOfBoundsForAdding(index: Int) {
        if (index !in 0..size) {
            throw IndexOutOfBoundsException("Exception Index: $index, Size: $size")
        }
    }

    override fun iterator(): Iterator<T> = object : Iterator<T> {
        private var nextIndex = 0
        override fun next(): T = elements[nextIndex++] as T

        override fun hasNext(): Boolean = nextIndex < size
    }

    companion object{
        private const val INITIAL_CAPACITY = 10
    }
}