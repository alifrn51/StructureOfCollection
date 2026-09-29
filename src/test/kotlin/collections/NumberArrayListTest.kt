package collections

import org.example.collections.NumberArrayList
import org.example.collections.NumberMutableList
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

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




    companion object{
        @JvmStatic
        fun mutableListSource() = listOf(NumberArrayList())
    }

}