package reflect.func

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions

class Person {

    var name: String? = null
    var age: Int = 0

    //成员函数
    fun setNameAndAge(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "Person [name=$name, age=$age]"
    }
}

//Person扩展函数
fun Person.getNameAndAge() = "name=$name,age=$age"

fun main() {
    val clz = Person::class
    val person = clz.createInstance()

    clz.functions.forEach { println(it.name) }
    val pfn1 = clz.functions.first()
    pfn1.call(person, "Tom", 20)
    println(person)

    val pfn2 = Person::setNameAndAge //KFunction3<Person,String,Int,Unit>

    pfn2(person, "Tony", 18) // Person [name=Tom, age=20]
    println(person) // Person [name=Tony, age=18]
    pfn2.call(person, "Ben", 28)
    println(person) // Person [name=Ben, age=28]
    pfn2.invoke(person,"Catty",16)
    println(person) //Person [name=Catty, age=16]

    val pfn3 = Person::getNameAndAge //KFunction3<Person,String>
    println(pfn3(person))
}