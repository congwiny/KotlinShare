package reflect.construct

//class Foo
//
//fun function(factory: () -> Foo) { //factory:一个无参并返回 Foo 类型的函数参数
//    val x: Foo = factory()
//    println(x) // Foo@4617c264
//}
//
//fun main() {
//    function(::Foo)
//}

data class Person(val name: String, val age: Int)

//扩展函数
fun Person.isAdult() = age >= 18

//构造方法引用存储
val createPerson = ::Person
/**
 * 尽管isAdult不是Person类的成员，还是可以通过引用访问它，这和访问实例的成员是一样的
 */
val predicate = Person::isAdult

fun main() {
    //构造方法引用 延迟执行创建类实例动作
    val p = createPerson("TomCat", 22)
    println(p) //Person(name=TomCat, age=22)
    println(predicate(p)) //true

    //绑定成员引用
    val dmitrysAgeFunction = p::age  //KProperty0<Int>
    println(dmitrysAgeFunction.get())//22 get不需要传入接收者对象
    println(dmitrysAgeFunction())//22

    val dmitrysAgeProperty = Person::age //KProperty1<Person, Int>
    println(dmitrysAgeProperty.get(p)) //22
}