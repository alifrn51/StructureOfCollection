package org.example.collections

class MyLinkedList<T> : MyMutableList<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var modeCound = 0

    override var size: Int = 0
        private set

    override fun add(element: T): Boolean {
        modeCound++
        val prevLast = last
        last = Node(prevLast, element)

        if (prevLast == null) {
            first = last
        } else {
            prevLast.next = last
        }
        size++
        return true
    }

    override fun add(index: Int, element: T) {
        modeCound++
        chackIndexOutOfBoundsForAdding(index)
        if (index == size) {
            add(element)
            return
        }
        if (index == 0) {
            val node = Node(null, element, first)
            first?.prev = node
            first = node
            size++
            return
        }
        val before = getNode(index - 1)
        val after = before.next
        val node = Node(before, element, after)
        before.next = node
        after?.prev = node
        size++
        return
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun get(index: Int): T {

        chackIndexOutOfBounds(index)
        return getNode(index).item
    }

    private fun getNode(index: Int): Node<T> {

        if (index == 0) return first!!
        if (index == size - 1) return last!!

        if (index < size / 2) {
            var node = first
            repeat(index) {
                node = node?.next
            }
            return node!!
        } else {
            var node = last
            repeat(size - index - 1) {
                node = node?.prev
            }
            return node!!
        }

    }

    private fun unlink(node: Node<T>) {
        modeCound++
        val before = node.prev
        val after = node.next
        before?.next = after
        after?.prev = before

        if (after == null) {
            last = before
        }
        if (before == null) {
            first = after
        }
        size--
    }


    override fun removeAt(index: Int) {
        modeCound++
        chackIndexOutOfBounds(index)
        val node = getNode(index)
        unlink(node)
    }

    override fun minus(index: Int) {
        chackIndexOutOfBounds(index)
        removeAt(index)
    }

    override fun remove(element: T) {
        modeCound++
        var node = first
        repeat(size) {
            if (node?.item == element) {
                unlink(node)
                return
            } else {
                node = node?.next
            }
        }

    }

    override fun clear() {
        modeCound++
        first = null
        last = null
        size = 0
    }

    override fun contains(element: T): Boolean {
        var node = first
        repeat(size) {
            if (node?.item == element) return true
            node = node?.next
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

    override fun iterator(): MutableIterator<T> = object : MutableIterator<T> {
        private val currentModeCound = modeCound
        private var nextNode = first
        override fun next(): T {
            if(currentModeCound != modeCound) throw ConcurrentModificationException()
            return nextNode?.item!!.also {
            nextNode = nextNode?.next}
        }

        override fun hasNext(): Boolean = nextNode != null

        override fun remove() {
            TODO("Not yet implemented")
        }
    }

    private class Node<T>(
        var prev: Node<T>? = null,
        val item: T,
        var next: Node<T>? = null
    )
}