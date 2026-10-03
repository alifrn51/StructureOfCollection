package org.example.collections

data class Item(val value: Int){

    override fun equals(other: Any?): Boolean {
        return other is Item && this.value == other.value
    }

    override fun hashCode(): Int {
        return value
    }
}