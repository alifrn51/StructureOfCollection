package org.example.collections

import kotlin.math.abs

class NumberHashSet : NumberMutableSet {

    var elements = arrayOfNulls<Node>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    override fun add(number: Int): Boolean {
        if (size >= elements.size * LOAD_FACTOR) {
            increasesArray()
        }
        return add(number, elements).also {
            if(it){
                size++
            }
        }
    }

    private fun add(number: Int, array: Array<Node?>): Boolean {
        val newElement = Node(number)
        val position = getElementPosition(number, array.size)
        var existedElement = array[position]
        if (existedElement == null) {
            array[position] = newElement
            return true
        } else {
            if (existedElement.item == number) {
                return false
            }
            while (true) {
                if (existedElement?.next == null) {
                    existedElement?.next = newElement
                    return true
                } else {
                    existedElement = existedElement.next
                }
            }
        }
    }

    private fun getElementPosition(element: Int, arraySize: Int): Int {
        return abs(element % arraySize)
    }

    private fun increasesArray() {
        val newArray = arrayOfNulls<Node>(elements.size * 2)
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                add(currentElement.item, newArray)
                currentElement = currentElement.next
            }
        }

        elements = newArray
    }

    override fun remove(number: Int) {
        val position = getElementPosition(number, elements.size)
        val existedElement = elements[position] ?: return
        if(existedElement.item == number){
            elements[position] = existedElement.next
            size--
            return
        }

        var before: Node? = existedElement
        while (before?.next != null){
            val removingElement = before.next
            if(removingElement?.item == number){
                before.next = removingElement.next
                size --
                return
            }else{
                before = before.next
            }
        }

    }

    override fun clear() {
        elements = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(number: Int): Boolean {
        val position = getElementPosition(number, elements.size)
        var existedElement = elements[position]
        while (existedElement != null) {
            if (existedElement.item == number) {
                return true
            } else {
                existedElement = existedElement.next
            }
        }
        return false
    }

    data class Node(
        val item: Int,
        var next: Node? = null
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75f
    }
}