import kotlin.reflect.full.memberProperties

//val x = 1
//
//fun main() {
//    val kProperty = ::x
//    println(::x.get()) //1
//    println(::x.name) //x
//}

var y = 1

//fun main() {
//    ::y.set(2)
//    println(y) //2
//
//    val strs = listOf("a", "bc", "def")
//
//    println(strs.map { string ->
//        string.length
//    })
//    println(strs.map { it.length }) //一个参数可以使用it替代
//    println(strs.map(String::length)) //[1, 2, 3]
//}



//var counter = 0
//fun main() {
//    val kProperty = ::counter //顶层属性的引用由KProperty0的实例表示，这里类型是KMutableProperty0<Int>
//    kProperty.setter.call(21)  //通过KCallable的call方法
//    kProperty.set(22)
//    println(kProperty.call()) //在KProperty实例上调用call方法会调用该属性的getter方法
//    println(kProperty.getter.call())
//    println(kProperty.get())//
//}

//fun main() {
//    class A(val p: Int)
//
//    val a = A(1)
//    val prop = A::p //成员属性的引用由KProperty1的实例表示，这里类型是KProperty1<A，Int>
//    //调用call方法会调用该属性的getter
//    println(prop.call(a)) //1
//    println(prop.getter.call(a)) //1
//    //更好获取属性值的方式：通过get方法
//    println(prop.get(a)) //1
//
//    val clz = A::class
//    //通过KClass提供的API获得KProperty实例
//    val prop1 = clz.memberProperties.first()
//    println(prop1.get(a)) //1
//}

val String.lastChar: Char
    get() = this[length - 1]

fun main() {
    println(String::lastChar.get("abc")) //c
    println("abc".lastChar) //c
}