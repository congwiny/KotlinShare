import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyException {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("abc"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Date readDate() throws ParseException {
        String str = "201A-18-18"; //非法格式日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 从字符串中解析日期
        return df.parse(str); //抛出ParseException异常，这是因为解析的字符串不是一个合法的日期
    }
}
