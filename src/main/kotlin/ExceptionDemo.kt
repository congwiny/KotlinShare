package exception

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

//在readDate函数前添加注解@Throws(ParseException::class)，其中ParseException需要处理的异常类
@Throws(ParseException::class)
fun readDate(): Date? {
    val str = "201A-18-18" //非法格式日期
    val df = SimpleDateFormat("yyyy-MM-dd")
    // 从字符串中解析日期
    return df.parse(str)
}