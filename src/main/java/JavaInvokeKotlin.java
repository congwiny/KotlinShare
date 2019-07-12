import exception.ExceptionDemoKt;
import kt.bean.Department;
import kt.bean.Employee;
import kt.bean.EmployeeKt;
import kt.user.User;
import level.PackageLevel;
import over.load.Animal;
import over.load.DisplayOverloading;
import over.load.JvmOverloadsKt;

import java.text.ParseException;
import java.util.Date;

public class JavaInvokeKotlin {
    public static void main(String[] args) {
        User user = new User("Tom", "12345");
        System.out.println(user.getName()); //Tom
        user.setPassword("54321");
        System.out.println(user.getPassword());//54321

        //访问顶层函数
        Double area = PackageLevel.rectangleArea(320.0, 480.0);
        System.out.println(area);
        //访问顶层属性
        System.out.println(PackageLevel.getArea());


        kt.Person p = new kt.Person();
        System.out.println(p.name); //Tony
        //System.out.println(p.age); // 'age' has private access in 'kt.Person'
        System.out.println(p.birthDate);  //null


        //访问静态字段
        System.out.println(Singleton.x); //10
        Singleton.birthDate = new Date();
        System.out.println(Account.interestRate); //0.018
        System.out.println(StaticField.MAX_COUNT); //500

        kt.ChatBot.greet("Tom");
        ChatBot.greet("Tom");

        //访问静态函数
        Singleton.displayX();
        Account.interestBy(5000);


        Employee emp = new Employee();
        //访问Kotlin中内部可见性的Employee成员属性no
        //int no = emp.getNo$share_main();//虽然能编译通过，运行时报错：“java:找不到符号”

        Department dept = new Department();
        //访问Kotlin中公有可见性的Department成员属性name
        dept.setName("市场部");

        //访问Kotlin中公有可见性的Employee中成员属性dept
        emp.setDept(dept);
        System.out.println(emp.getDept());

        //访问Kotlin中内部可见性的顶层属性MAX_COUNTS
        System.out.println(EmployeeKt.MAX_COUNTS);



        //Animal构造函数添加@JvmOverloads注解，它会生成两个Java重载构造函数
        Animal animal1 = new Animal(10, true);
        Animal animal2 = new Animal(10);

        DisplayOverloading dis1 = new DisplayOverloading();
        //DisplayOverloading声明了成员函数，它有默认参数，函数前也添加@JvmOverloads注解，它会生成两个Java重载函数
        dis1.display('A');
        dis1.display('B', 20);

        //JvmOverloadsKt声明了顶层函数，它也有默认参数，函数前也添加@JvmOverloads注解。它会生成两个Java静态重载函数
        JvmOverloadsKt.makeCoffee();
        JvmOverloadsKt.makeCoffee("摩卡咖啡");

        /*
          在Java中ParseException是受检查异常，
          如果在Java中调用Kotlin代码中的readDate函数，由于readDate函数没有声明抛出ParseException异常，
          编译器不会检查要求Java程序捕获异常处理。
         */
        try {
            ExceptionDemoKt.readDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*
          调用Java代码中的readDate函数，需要捕获异常
         */
        try {
            MyException.readDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
