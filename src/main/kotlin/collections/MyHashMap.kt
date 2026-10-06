package org.example.collections

import kotlin.collections.get
import kotlin.math.abs

class MyHashMap<K, V> : MyMutableMap<K, V> {

    var modeCound = 0
    var elements = arrayOfNulls<Node<K, V>>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    override fun put(key: K, value: V): V? {
        if (size >= elements.size * LOAD_FACTOR) {
            increasesArray()
        }
        return put(key, value, elements).also { oldValue ->
            if (oldValue == null) {
                size++
            }
        }
    }

    private fun put(key: K, value: V, array: Array<Node<K, V>?>): V? {
        modeCound++
        val newElement = Node(key, value)
        val position = getElementPosition(key, array.size)
        var existedElement = array[position]
        if (existedElement == null) {
            array[position] = newElement
            return null
        } else {

            while (true) {
                if (existedElement?.key == key) {
                    val oldValue = existedElement.value
                    existedElement.value = value
                    return oldValue
                }
                if (existedElement?.next == null) {
                    existedElement?.next = newElement
                    return null
                } else {
                    existedElement = existedElement.next
                }
            }
        }
    }

    private fun getElementPosition(element: K, arraySize: Int): Int {
        return abs(element.hashCode() % arraySize)
    }

    private fun increasesArray() {
        val newArray = arrayOfNulls<Node<K, V>>(elements.size * 2)
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                put(currentElement.key, currentElement.value, newArray)
                currentElement = currentElement.next
            }
        }

        elements = newArray
    }

    fun keyIterator(): MutableIterator<K>{
        return object : MutableIterator<K> {
            private val currentModeCound = modeCound
            private var nodeIndex = 0
            private var nextNode = elements[nodeIndex]
            private var nextIndex = 0

            override fun next(): K {
                if (currentModeCound != modeCound) throw ConcurrentModificationException()
                while (nextNode == null) {
                    nextNode = elements[++nodeIndex]
                }
                return nextNode?.key!!.also {
                    nextIndex++
                    nextNode = nextNode?.next
                }
            }

            override fun hasNext(): Boolean = nextIndex < size
            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }


    override fun remove(key: K): V? {
        modeCound++
        val position = getElementPosition(key, elements.size)
        val existedElement = elements[position] ?: return null
        if (existedElement.key == key) {
            elements[position] = existedElement.next
            size--
            return existedElement.value
        }

        var before: Node<K, V>? = existedElement
        while (before?.next != null) {
            val removingElement = before.next
            if (removingElement?.key == key) {
                before.next = removingElement.next
                size--
                return removingElement.value
            } else {
                before = before.next
            }
        }

        return null

    }

    override fun clear() {
        modeCound++
        elements = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun get(key: K): V? {
        val position = getElementPosition(key, elements.size)
        var existedElement = elements[position]
        while (existedElement != null) {
            if (existedElement.key == key) {
                return existedElement.value
            } else {
                existedElement = existedElement.next
            }
        }
        return null
    }

    override fun containsKey(key: K): Boolean {
        val position = getElementPosition(key, elements.size)
        var existedElement = elements[position]
        while (existedElement != null) {
            if (existedElement.key == key) {
                return true
            } else {
                existedElement = existedElement.next
            }
        }
        return false
    }

    override fun containsValue(value: V): Boolean {
        foreach {
            if (it.value == value) return true
        }
        return false
    }


    override val keys: MySet<K>
        get() = MyHashSet<K>().apply {
            foreach {
                add(it.key)
            }
        }
    override val value: MyCollection<V>
        get() = MyArrayList<V>().apply {
            foreach {
                add(it.value)
            }
        }


    private inline fun foreach(operation: (Node<K, V>) -> Unit) {
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                operation(currentElement)
                currentElement = currentElement.next
            }
        }
    }


    data class Node<K, V>(
        val key: K,
        var value: V,
        var next: Node<K, V>? = null
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75f
    }
}