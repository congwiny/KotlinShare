@file:JvmName("StaticField")

import java.util.*

object Singleton {   //Singleton声明对象
    @JvmField
    val x = 10 //@JvmField注解Singleton对象中x属性

    lateinit var birthDate: Date //声明延迟属性birthDate

    //@JvmStatic注解Singleton对象中displayX函数
    @JvmStatic
    fun displayX() {
        println(x)
    }
}

class Account {   //Account伴生对象
    companion object {
        //声明伴生对象中interestRate属性是const常量类型
        const val interestRate = 0.018

        //JvmStatic注解伴生对象中interestBy函数
        @JvmStatic
        fun interestBy(amt: Double): Double {
            return interestRate * amt
        }
    }
}

//声明顶层常量MAX_COUNT
const val MAX_COUNT = 500