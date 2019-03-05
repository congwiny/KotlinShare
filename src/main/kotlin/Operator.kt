package operator.overload

data class Point(val x: Int, val y: Int)

//简便写法：operator fun Point.unaryMinus() = Point(-x, -y)
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}

fun main(args: Array<String>) {

    val counter = Counter(3)
    println(counter + 3) //Counter(dayIndex=6)

    val p = Point(10, 20)
    /*
       -p -> p.unaryMinus()
     */
    println(-p) //Point(x=-10, y=-20)
}