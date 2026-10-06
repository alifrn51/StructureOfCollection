package collections

import org.example.collections.Item
import org.example.collections.MyHashMap
import org.example.collections.MyHashSet
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class MyMutableMapTest {


    private val numbers = MyHashMap<Int, String>()

    @Test
    fun `When added 100 elements Then size 100`() {
        repeat(100) {
            numbers.put(it,"number: $it")
        }
        assertEquals(100, numbers.size)
    }

    @Test
    fun `When added 10 similar keys Then size 1`() {
        repeat(10) {
            numbers.put(1,"Number: $it")
        }
        assertEquals(1, numbers.size)
    }

    @Test
    fun `When added 10 similar keys Then return last value`() {
        var result: String? = null
        repeat(10) {
            result = numbers.put(1,"Number: $it")
        }
        assertEquals("Number: 8", result)
    }


    @Test
    fun `When key present in map Then method result true`() {
        repeat(10) {
            numbers.put(it,"Number: $it")
        }
        assertTrue { numbers.containsKey(9) }

    }

    @Test
    fun `When key absent in map Then method result false`() {
        repeat(10) {
            numbers.put(it,"Number: $it")
        }
        assertFalse { numbers.containsKey(10) }
    }

    @Test
    fun `When value present in map Then method result true`() {
        repeat(10) {
            numbers.put(it,"Number: $it")
        }
        assertTrue { numbers.containsValue("Number: 1") }

    }

    @Test
    fun `When value absent in map Then method result false`() {
        repeat(10) {
            numbers.put(it,"Number: $it")
        }
        assertFalse { numbers.containsValue("10") }
    }

    @Test
    fun `When element removed Then size is decreased`() {
        repeat(10) {
            numbers.put(it,"Number: $it")
        }
        numbers.remove(1)
        assertEquals(9, numbers.size)
    }

    @Test
    fun `When element removed Then contains return false`() {
        repeat(10) {
            numbers.put(it,"Number: $it")
        }
        numbers.remove(1)
        assertFalse { numbers.containsKey(1) }
    }

    @Test
    fun `When set is cleared Then size is 0`() {
        repeat(10) {
            numbers.put(it,"Number: $it")
        }
        numbers.clear()
        assertEquals(0, numbers.size)
    }

    @Test
    fun `When set is cleared Then all element is absent`() {
        repeat(10) {
            numbers.put(it,"Number: $it")
        }
        numbers.clear()
        repeat(10){
            Assertions.assertFalse { numbers.containsKey(1) }
        }
    }


}