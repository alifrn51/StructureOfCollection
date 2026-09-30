package org.example.collections

class NumberArrayList : NumberMutableList {

    private var numbers = arrayOfNulls<Int>(10)

    override var size: Int = 0
        private set

    override fun add(number: Int) {
        growUp()
        numbers[size] = number
        size++
    }

    override fun plus(number: Int) {
        add(number)
    }

    private fun growUp() {
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            System.arraycopy(numbers, 0, newArray, 0, size)
            numbers = newArray
        }
    }

    override fun add(index: Int, number: Int) {
        chackIndexOutOfBoundsForAdding(index)
        growUp()
        System.arraycopy(numbers, index, numbers, index + 1, size - index)
        numbers[index] = number
        size++
    }

    override fun get(index: Int): Int {
        chackIndexOutOfBounds(index)
        return this.numbers[index]!!
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

    override fun remove(number: Int) {
        for (index in 0 until size) {
            if (number == numbers[index]) {
                removeAt(index)
            }
        }
    }

    override fun clear() {
        numbers = arrayOfNulls(10)
        size = 0
    }

    override fun contains(number: Int): Boolean {
        for (i in 0 until size) {
            if (number == numbers[i]) {
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