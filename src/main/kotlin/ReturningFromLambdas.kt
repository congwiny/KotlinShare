package lambda.funs

fun main() {
    val people = listOf(Person("Tom", 28), Person("Alice", 29), Person("Bob", 31))
    lookForAlice2(people)
}

fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return //非局部返回，return从最近的使用fun关键字声明的函数返回
        }
    }
    println("Alice is not found")
}

/**
 * 局部返回： 使用标签返回
 */
fun lookForAlice1(people: List<Person>) {
    people.forEach label@{
        if (it.name == "Alice") {
            println("Found!")
            return@label
        }
    }
    println("Alice might be somewhere")
}


fun lookForAlice2(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return@forEach
        }
    }
    println("Alice might be somewhere")
}

/**
 * 匿名函数：默认使用局部返回
 */
fun lookForAlice3(people: List<Person>) {
    people.forEach(fun(person) { //使用匿名函数取代lambda表达式
        if (person.name == "Alice") {
            println("Found!")
            return //return 指向最近的函数：一个匿名函数
        }
        println("${person.name} is not Alice")
    })
}

data class Person(val name: String, val age: Int)