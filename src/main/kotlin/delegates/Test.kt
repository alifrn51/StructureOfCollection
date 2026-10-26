package org.example.delegates

import kotlin.io.encoding.Base64
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {

    val user = User()
    /*user.password = "123456"
    user.creditCardNumber = "000 0000 000"
    println(user.password)
    println(user.creditCardNumber)*/

    user.a = 10
    user.a = 1

}

class User{
    var a by observable(0) { oldValue, newValue ->
        println("Old value: $oldValue New value: $newValue")
    }
    var password: String  by encryptedProperty()

    var creditCardNumber : String by encryptedProperty()
}

fun <T> observable(
    initialValue: T,
    onChanged: (oldValue: T,newValue: T) -> Unit
) = ObservableProperty(initialValue, onChanged)

class ObservableProperty<T>(
    initialValue: T,
    private val onChanged: (oldValue: T,newValue: T) -> Unit
): ReadWriteProperty<Any, T>{

    private var currentValue = initialValue

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return currentValue
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        val oldValue = currentValue
        currentValue = value
        onChanged(oldValue,currentValue)
    }
}

fun encryptedProperty() = EncryptedProperty()

class EncryptedProperty(): ReadWriteProperty<Any, String>{
    private var encryptedValue = ""
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Getting value, encoded: $encryptedValue")
        val decoded = String(Base64.decode(encryptedValue))
        println("Getting value, decoded: $decoded")
        return decoded
    }

    override fun setValue(
        thisRef: Any,
        property: KProperty<*>,
        value: String
    ) {
        println("Setter value, value: $value")
        val encoded = Base64.encode(value.toByteArray())
        println("Setter value, encoded: $encoded")
        encryptedValue = encoded
    }
}