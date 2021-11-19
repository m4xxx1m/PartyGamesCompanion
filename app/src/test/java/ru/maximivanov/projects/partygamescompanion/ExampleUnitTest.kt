package ru.maximivanov.projects.partygamescompanion

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun additionNumInString() {
        val num = 5
        assertEquals("6)", "${num+1})")
    }

    @Test
    fun companionObjects() {
        val u1 = User()
        assertEquals(1, u1.getNum())
        val u2 = User()
        assertEquals(2, u2.getNum())
        val u3 = User()
        assertEquals(3, u3.getNum())
    }
}

class User {
    private val num: Int = getN()
    private var name: String? = null
    private var money: Float? = null

    public fun getNum() = num
    public fun getName() = name
    public fun getMoney() = money

    public fun setUser(name:String, money:Float) {
        this.name = name
        this.money = money
    }

    companion object {
        private var staticN = 1
        fun getN() = staticN++
    }
}