import kotlin.reflect.KFunction2

fun isOdd(x: Int) = x % 2 != 0

//fun main() {
////sampleStart
//    val numbers = listOf(1, 2, 3)
//    println(numbers.filter(::isOdd)) //[1,3]
////sampleEnd
//}

//fun main() {
//    //sampleStart
//    fun isOdd(x: Int) = x % 2 != 0
//    fun isOdd(s: String) = s == "brillig" || s == "slithy" || s == "tove"
//
//    val numbers = listOf(1, 2, 3)
//    println(numbers.filter(::isOdd)) // 引用到 isOdd(x: Int)
////sampleEnd
//}

fun sum(x: Int, y: Int) = x + y

fun main() {
    val sumFun: (Int, Int) -> Int = ::sum
    println(sumFun(1, 2))

    //一个函数类型的变量（函数引用）属于 KFunction<out R> 的子类型之一
    val kFunction2: KFunction2<Int, Int, Int> = ::sum
    println(kFunction2.invoke(1, 2) + kFunction2(3, 4)) //10

    //KFunction接口继承自KCallable和Function
    val sumFun2 = ::sum
    /**
     * 调用KCallable接口的call方法，传入可变参数，因为call方法是对所有类型都有效的通用手段，但它不提供类型安全性。
     * 如果用错误数量的实参去调用函数，就会抛出一个运行时异常IllegalArgumentException
     */
    println(sumFun2.call(3, 6)) //调用KCallable接口的call方法
    println(sumFun2.invoke(2, 5)) //调用Function接口的invoke方法
    //会被编译成sumFun2.invoke(1, 3)
    println(sumFun2(1, 3))

    //String类里有2个toCharArray函数，需要指定类型限定：(String) -> CharArray
    val toCharArrayFun: (String) -> CharArray = String::toCharArray
    val arr = toCharArrayFun.invoke("abcd") // 或者使用toCharArrayFun("abcd")
    arr.forEach {
        println(it)
    }

    val calc = Calc()
    //isOddFun类型限定
    val isOddFun: (Calc, String) -> Boolean = Calc::isOdd
    println(isOddFun(calc, "tove")) //true

    val isOddFun2: (String) -> Boolean = calc::isOdd
    println(isOddFun2("brillig")) //true
}

class Calc {
    fun isOdd(x: Int) = x % 2 != 0
    fun isOdd(s: String) = s == "brillig" || s == "slithy" || s == "tove"
}
