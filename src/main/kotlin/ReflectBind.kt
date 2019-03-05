package reflect.bind

//fun main() {
//    val numberRegex = "\\d+".toRegex()
//    println(numberRegex.matches("29"))
//
//    //val matches: (Regex, CharSequence) -> Boolean = Regex::matches
//    val matches = Regex::matches //Regex的matches函数引用
//    println(matches(numberRegex, "29")) //需要传入numberRegex对象参数
//
//    //val isNumber: (CharSequence) -> Boolean = numberRegex::matches
//    val isNumber = numberRegex::matches //把Regex的matches函数引用绑定到numberRegex对象上
//    println(isNumber("29")) //不需要传入numberRegex对象参数
//
//    //绑定的引用可以用于任何需要一个函数类型表达式的场景
//    val strings = listOf("abc", "124", "a70")
//    println(strings.filter(numberRegex::matches)) //[124]
//}

fun main() {
    val prop = "abc"::length
    println(prop.get()) //3
}