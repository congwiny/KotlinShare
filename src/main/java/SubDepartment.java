import kt.bean.Department;
import kt.bean.Employee;

public class SubDepartment extends Department {
    void display() {
        //继承Kotlin中Department类保护可见性的成员属性no
        System.out.println(this.getNo());
        //继承Kotlin中Department类公有可见性的成员属性name
        System.out.println(this.getName());
    }

    void setEmployee() {
        Employee employee = new Employee();
        //访问Kotlin中内部可见性的Employee成员属性no
        //employee.setNo$share(1);
        //访问Kotlin中公有可见性的Employee中成员属性dept
        employee.setDept(this);
    }
}
