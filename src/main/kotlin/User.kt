package kt.user

/**
 * var声明的属性会生成setter和getter函数，如果是val声明的属性是只读的，只生成getter函数。
 */
data class User(var name: String, var password: String) {
    val age: Int? = null
}