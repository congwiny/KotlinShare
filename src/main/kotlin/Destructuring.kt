package destructuring

/**
 * 事实上，解构声明再次用到了约定的原理。
 * 要在解构声明中初始化每个变量，会调用名为componentN的函数，其中N是声明中变量的位置。
 */
class Point(val x: Int, val y: Int) {
    /**
     * 手动为非数据类实现解构功能
     * 请注意，componentN() 函数需要用 operator 关键字标记，以允许在解构声明中使用它们。
     */
    operator fun component1() = x

    operator fun component2() = y
}

/**
 * 对于数据类，编译器为每个在主构造方法中声明的属性生成一个componentN函数。
 */
data class Point2(val x: Int, val y: Int)

fun main(args: Array<String>) {
    val (x, y) = Point2(10, 20)
    println("x=$x,y=$y") //x=10,y=20

    val person = Person("Jack",
        20,
        "male",
        "Beijing",
        "1234556",
        "Jack@gmail.com",
        false,
        "Programmer")
    val (name, age, sex, address, phone, email, marry, job) = person
    println("""name=$name,
        |age=$age,
        |sex=$sex,
        |address=$address,
        |phone=$phone,
        |email=$email,
        |marry=$marry,
        |job=$job""".trimMargin())

    val (one,two,three,four,five) = listOf(1,2,3,4,5,6,7,8)
    println("one=$one,two=$two,three=$three,four=$four,five=$five")
}


data class Person(val name: String,
                  val age: Int,
                  val sex: String,
                  val address: String,
                  val phone: String,
                  val email: String,
                  val marry: Boolean,
                  val job: String)
