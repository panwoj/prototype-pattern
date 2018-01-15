package employees;

import java.util.List;

public class Application {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();

        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmployeesList();
        list.add("Ann");
        List<String> list1 = empsNew1.getEmployeesList();
        list1.remove("John");

        System.out.println("emps List: " + emps.getEmployeesList());
        System.out.println("empsNew List: " + list);
        System.out.println("empsNew1 List: " + list1);
    }
}
