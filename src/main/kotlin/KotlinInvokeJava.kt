import java.io.BufferedReader
import java.io.FileReader
import java.util.*

fun main(args: Array<String>) {
    val obj = MyJavaClass.`object` // 避免Kotlin关键字object
    println(obj)

    /**
     * 平台类型，这些类型在Java中声明了一个变量或返回的数据可能为空，也可能非空。
     * Kotlin在调用它们时会放弃类型检查。
     */
    val person = Person()
    val date = person.birthDate
    println("date = $date")    // null

    /**
     * 读取birthDate属性赋值给变量date，
     * 此时date的类型是由编译器自动推导出来的，
     * IntelliJ IDEA IDE表示的平台类型是Date!，它可以接收空值。
     */
    val date1: Date? = person.birthDate
    println("date1 = $date1")  // null

    /**
     * date2是非空类型，不能接收空值因此代码
     * 抛出异常, Exception in thread "main" java.lang.IllegalStateException: person.birthDate must not be null
     */
    val date2: Date = person.birthDate
    println("date2 = $date2")

    //Kotlin中不用必须捕获
    val br = BufferedReader(FileReader("abc"))


    val n1 = 10
    val n2 = 5

    // 实现加法计算Calculable对象
    val f1 = Calculable { a, b -> a + b }
    // 实现减法计算Calculable对象
    val f2 = Calculable { a, b -> a - b }

    // 调用calculateInt函数进行加法计算
    println("$n1 + $n2 = ${f1.calculateInt(n1, n2)}")
    // 调用calculateInt函数进行减法计算
    println("$n1 - $n2 = ${f2.calculateInt(n1, n2)}")

}