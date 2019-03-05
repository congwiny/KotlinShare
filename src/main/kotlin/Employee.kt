package kt.bean

// 员工类
internal class Employee {
    internal var no: Int = 10          // 内部可见性Java端可见
    protected var job: String? = null   // 保护可见性Java端子类继承可见

    private var salary: Double = 0.0    // 私有可见性Java端不可见
        set(value) {
            if (value >= 0.0) field = value
        }
    lateinit var dept: Department     // 公有可见性Java端可见
}

// 部门类，open可以被继承
open class Department {
    protected var no: Int = 0  // 保护可见性Java端子类继承可见
    var name: String = ""     // 公有可见性Java端可见
}

internal const val MAX_COUNTS = 500  // 内部可见性Java端可见
private const val MIN_COUNTS = 0     // 私有可见性Java端不可见