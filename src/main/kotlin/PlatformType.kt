
fun main(args: Array<String>) {
    //val s: Int = Person().p
    val s: String? = Person().name
    println(s)

    val hobby = Person().hobbys

    val a = listOf("ab")
    //if (a is List<Int>)
    // if (a is List<*>)
    val children = Person().supperman
}