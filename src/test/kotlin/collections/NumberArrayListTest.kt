package collections

import org.example.collections.NumberArrayList
import org.example.collections.NumberMutableList
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NumberArrayListTest {


    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 1 element the size is 1`(list: NumberMutableList){
        list.add(0)
        assertEquals(expected = 1, actual = list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 10 element the size is 10`(list: NumberMutableList){
        repeat(10){
            list.add(it)
        }
        assertEquals(expected = 10, actual = list.size)
    }


    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 5th element then result is correct`(list: NumberMutableList){
        repeat(10){
            list.add(it)
        }
        assertEquals(expected = 5, actual = list.get(5))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 100 element the size is 100`(list: NumberMutableList){
        repeat(100){
            list.add(it)
        }
        assertEquals(expected = 100, actual = list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 50th element then result is correct`(list: NumberMutableList){
        repeat(100){
            list.add(it)
        }
        assertEquals(expected = 50, actual = list.get(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element added to first position the it is in first position`(list: NumberMutableList){
        repeat(100){
            list.add(it, 50)
        }
        list.add(0,1000)
        assertEquals(expected = 1000, actual = list.get(0))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element added to last position the it is in last position`(list: NumberMutableList){
        repeat(100){
            list.add(it,55)
        }
        list.add(100,1000)
        assertEquals(expected = 1000, actual = list.get(100))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element added to first position then size increases by one`(list: NumberMutableList){
        repeat(100){
            list.add(it)
        }
        list.add(100,1000)
        assertEquals(expected = 101, actual = list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element removed then size decreased`(list: NumberMutableList){
        repeat(100){
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(expected = 99, actual = list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When removed 50th element next value at this position`(list: NumberMutableList){
        repeat(100){
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(expected = 51, actual = list.get(50))
    }


    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When removed value 50 next value at this position`(list: NumberMutableList){
        repeat(100){
            list.add(it)
        }
        list.remove(50)
        assertEquals(expected = 51, actual = list.get(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When all elements are cleared the size is 0`(list: NumberMutableList){
        repeat(100){
            list.add(it)
        }
        list.clear()
        assertEquals(expected = 0, actual = list.size)
    }


    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list contains element then method returns true`(list: NumberMutableList){
        repeat(100){
            list.add(it)
        }
        assertTrue (list.contains(90))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list does not contains element then method returns false`(list: NumberMutableList){
        repeat(100){
            list.add(it)
        }
        assertFalse (list.contains(100))
    }





    companion object{
        @JvmStatic
        fun mutableListSource() = listOf(NumberArrayList())
    }

}