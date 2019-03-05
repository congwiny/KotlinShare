package op.infix

data class Person(val name: String, val age: Int)

infix fun Person.grow(years: Int): Person {
    return Person(name, age + years)
}

fun main(args: Array<String>) {
    val person = Person("Jack", 20)
    println(person.grow(2)) // Person(name=Jack, age=22)
    println(person grow 2) // Person(name=Jack, age=22)
}