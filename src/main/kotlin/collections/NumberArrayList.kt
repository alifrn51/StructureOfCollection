package org.example.collections

class NumberArrayList : NumberMutableList {

    private var numbers = arrayOfNulls<Int>(10)

    override var size: Int = 0
        private set

    override fun add(number: Int) {
        growUp()
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            for (index in numbers.indices) {
                newArray[index] = numbers[index]
            }
            numbers = newArray
        }
        numbers[size] = number
        size++
    }

    private fun growUp(){
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            for (index in numbers.indices) {
                newArray[index] = numbers[index]
            }
            numbers = newArray
        }
    }
    override fun add(index: Int, number: Int)  {
        growUp()
        for (i in size downTo index + 1){
            numbers[i] = numbers[i - 1]
        }
        numbers[index] = number
        size++
    }

    override fun get(index: Int): Int {
        return this.numbers[index]!!
    }

    override fun removeAt(index: Int) {
        for (i in index until size - 1) {
            numbers[i] = numbers[i + 1]
        }
        size--
        numbers[size] = null
    }

    override fun remove(number: Int) {
        for(index in 0 until size){
            if(number == numbers[index]){
                removeAt(index)
            }
        }
    }

    override fun clear() {
        numbers = arrayOfNulls(10)
        size = 0
    }

    override fun contains(number: Int): Boolean {
        for (i in 0 until size){
            if(number == numbers[i]){
                return true
            }
        }
        return false
    }
}