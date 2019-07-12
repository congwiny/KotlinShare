import java.util.Date;
import java.util.List;

public class Person {
    // 名字
    private String name = "Tony";
    // 年龄
    private int age = 18;
    // 出生日期
    private Date birthDate;

    private List<String> mHobbys;

    public Person p;

    public String[] children;

    public Person[] supperman = new Superman[3];

    public int getAge() {
        return age;
    }

    public List<String> getHobbys() {
        return mHobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.mHobbys = hobbys;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
