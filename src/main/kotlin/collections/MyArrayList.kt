package org.example.collections

class MyArrayList<T> : MyMutableList<T> {

    private var numbers = arrayOfNulls<Any>(10)

    override var size: Int = 0
        private set

    override fun add(element: T) {
        growUp()
        numbers[size] = element
        size++
    }

    override fun plus(element: T) {
        add(element)
    }

    private fun growUp() {
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Any>(numbers.size * 2)
            System.arraycopy(numbers, 0, newArray, 0, size)
            numbers = newArray
        }
    }

    override fun add(index: Int, element: T) {
        chackIndexOutOfBoundsForAdding(index)
        growUp()
        System.arraycopy(numbers, index, numbers, index + 1, size - index)
        numbers[index] = element
        size++
    }

    override fun get(index: Int): T {
        chackIndexOutOfBounds(index)
        return this.numbers[index] as T
    }

    override fun removeAt(index: Int) {
        chackIndexOutOfBounds(index)
        System.arraycopy(numbers, index+1, numbers, index, size - index -1)
        size--
        numbers[size] = null
    }

    override fun minus(index: Int) {
        removeAt(index)
    }

    override fun remove(element: T) {
        for (index in 0 until size) {
            if (element == numbers[index]) {
                removeAt(index)
            }
        }
    }

    override fun clear() {
        numbers = arrayOfNulls(10)
        size = 0
    }

    override fun contains(element: T): Boolean {
        for (i in 0 until size) {
            if (element == numbers[i]) {
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

}