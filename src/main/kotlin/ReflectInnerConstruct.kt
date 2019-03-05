class Outer {
    inner class Inner
    class Nest
}

fun main() {
    //创建外部类实例
    val o = Outer()
    val boundInnerCtor = o::Inner
    println(boundInnerCtor.invoke()) //Outer$Inner@2626b418
    println(boundInnerCtor()) //Outer$Inner@5a07e868

    //嵌套类构造方法的引用
    val nestCtor = Outer::Nest
    println(nestCtor()) //Outer$Nest@2626b418
}