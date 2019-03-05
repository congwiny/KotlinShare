import kotlin.reflect.KClass
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaSetter

class A(var p: Int)

fun main() {
    println(A::p.javaGetter) // 输出 "public final int A.getP()"
    println(A::p.javaField)  // 输出 "private final int A.p"

    println(A::p.javaSetter) // 输出 "public final void A.setP(int)"
    println(A::p.javaClass is Class)  // 输出 "class ReflectCompatKt$main$4"
    //要获得对应于 Java 类的 Kotlin 类，请使用 .kotlin 扩展属性
    println(A::p.javaClass.kotlin is KClass)  // 输出 "class ReflectCompatKt$main$5"

    val person = Person()
    val clazz = person.javaClass
}