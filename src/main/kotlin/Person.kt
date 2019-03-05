package kt

import java.util.*

class Person {
    // 名字
    @JvmField
    var name = "Tony"
    // 年龄
    var age = 18
    // 出生日期
    lateinit var birthDate: Date
}
