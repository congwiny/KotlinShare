package over.load

class Animal @JvmOverloads constructor(
    val age: Int,
    val sex: Boolean = false
)

class DisplayOverloading {
    @JvmOverloads
    fun display(c: Char, num: Int = 1) {
        println(c + " " + num)
    }
}

@JvmOverloads
fun makeCoffee(type: String = "卡布奇诺"): String {
    return "制作一杯${type}咖啡。"
}