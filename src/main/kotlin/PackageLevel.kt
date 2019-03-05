@file:JvmName("PackageLevel")

package level

//顶层属性
val area = 100.0

//顶层函数
fun rectangleArea(width: Double, height: Double): Double {
    val area = width * height
    return area
}