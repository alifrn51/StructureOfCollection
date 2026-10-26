package org.example.delegates

import java.util.function.IntFunction

fun main() {

    val zombie = Zombie("Daniel")
    val human = Human("Ali")

    zombie.move()
    zombie.fight()
    human.move()
    human.fight()

    val premiumHuman = PremiumPlayer(human)
    premiumHuman.callForHelp()

    val flyingHuman = FlyingPlayer(human)
    flyingHuman.flying()

    val mutableList = LoggingMutableList(mutableListOf(1,2,3))
    mutableList.add(10)

}

interface Player{
    fun move()
    fun fight()
}

data class Zombie(val name: String): Player{
    override fun move() {
        println("I'm running very slowing...")
    }

    override fun fight() {
        println("I'm eating human!")
    }
}


data class Human(val name: String): Player{
    override fun move() {
        println("I'm running very fast...")
    }

    override fun fight() {
        println("I'm shooting a gun...")
    }
}

data class FlyingPlayer(val player: Player): Player by player{

    fun flying(){
        println("I'm flying...")
    }
}

data class PremiumPlayer(val player: Player): Player by player{

    fun callForHelp(){
        println("HELP ME!")
    }
}


class LoggingMutableList<T>(private val mutableList: MutableList<T>): MutableList<T> by mutableList{

    override fun add(element: T): Boolean {
        return mutableList.add(element).also {
            println("Element $element added to list.")
        }
    }
}