package org.example.collections

class MyLinkedList : MyMutableList {

    private var first: Node? = null
    private var last: Node? = null

    override var size: Int = 0
        private set

    override fun add(number: Int) {

        val prevLast = last
        last = Node(prevLast, number)

        if (prevLast == null) {
            first = last
        }else{
            prevLast.next = last
        }
        size++
    }

    override fun add(index: Int, number: Int) {
        chackIndexOutOfBoundsForAdding(index)
        if (index == size) {
            add(number)
            return
        }
        if (index == 0) {
            val node = Node(null,number, first)
            first?.prev  = node
            first = node
            size++
            return
        }
        val before = getNode(index - 1)
        val after = before.next
        val node = Node(before,number, after)
        before.next = node
        after?.prev = node
        size++
        return
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun get(index: Int): Int {

        chackIndexOutOfBounds(index)
        return getNode(index).item
    }

    private fun getNode(index: Int): Node {

        if (index == 0) return first!!
        if (index == size - 1) return last!!

        if(index < size / 2){
            var node = first
            repeat(index) {
                node = node?.next
            }
            return node!!
        }else{
            var node = last
            repeat(size - index - 1) {
                node = node?.prev
            }
            return node!!
        }

    }

    private fun unlink(node: Node){
        val before = node.prev
        val after = node.next
        before?.next = after
        after?.prev = before

        if(after == null){
            last = before
        }
        if(before == null){
            first = after
        }
        size--
    }


    override fun removeAt(index: Int) {
        chackIndexOutOfBounds(index)
        val node = getNode(index)
        unlink(node)
    }

    override fun minus(index: Int) {
        chackIndexOutOfBounds(index)
        removeAt(index)
    }

    override fun remove(number: Int) {

        var node = first
        repeat(size) {
            if (node?.item == number) {
                unlink(node)
                return
            } else {
                node = node?.next
            }
        }

    }

    override fun clear() {
        first = null
        last = null
        size = 0
    }

    override fun contains(number: Int): Boolean {
        var node = first
        repeat(size) {
            if (node?.item == number) return true
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

    private class Node(
        var prev: Node? = null,
        val item: Int,
        var next: Node? = null
    )
}