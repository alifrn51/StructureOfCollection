package collections

import org.example.collections.Item
import org.example.collections.NumberHashSet
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberHashSetTest {

    private val numbers = NumberHashSet<Item>()

    @Test
    fun `When added 100 elements Then size 100`() {
        repeat(100) {
            numbers.add(Item(it))
        }
        assertEquals(100, numbers.size)
    }

    @Test
    fun `When added 10 similar elements Then size 1`() {
        repeat(10) {
            numbers.add(Item(1))
        }
        assertEquals(1, numbers.size)
    }

    @Test
    fun `When adding is succeed Then method return true`() {
        assertTrue { numbers.add(Item(0)) }
    }

    @Test
    fun `When adding is failed Then method return false`() {
        numbers.add(Item(0))
        assertFalse { numbers.add(Item(0)) }
    }

    @Test
    fun `When element present in set Then method result true`() {
        repeat(10) {
            numbers.add(Item(it))
        }
        assertTrue { numbers.contains(Item(9)) }

    }

    @Test
    fun `When element absent in set Then method result false`() {
        repeat(10) {
            numbers.add(Item(it))
        }
        assertFalse { numbers.contains(Item(10)) }

    }

    @Test
    fun `When element removed Then size is decreased`() {
        repeat(10) {
            numbers.add(Item(it))
        }
        numbers.remove(Item(1))
        assertEquals(9, numbers.size)
    }

    @Test
    fun `When element removed Then contains return false`() {
        repeat(10) {
            numbers.add(Item(it))
        }
        numbers.remove(Item(1))
        assertFalse { numbers.contains(Item(1)) }
    }

    @Test
    fun `When set is cleared Then size is 0`() {
        repeat(10) {
            numbers.add(Item(it))
        }
        numbers.clear()
        assertEquals(0, numbers.size)
    }

    @Test
    fun `When set is cleared Then all element is absent`() {
        repeat(10) {
            numbers.add(Item(it))
        }
        numbers.clear()
        repeat(10){
            assertFalse { numbers.contains(Item(it)) }
        }
    }
}