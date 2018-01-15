package employees;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
    private List<String> employeesList;

    public Employees() {
        this.employeesList = new ArrayList<>();
    }

    public Employees(List<String> employeesList) {
        this.employeesList = employeesList;
    }

    public void loadData() {
        employeesList.add("John");
        employeesList.add("Tim");
        employeesList.add("Tom");
        employeesList.add("Jane");
    }

    public List<String> getEmployeesList() {
        return employeesList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<String>();
        for(String s : this.getEmployeesList()) {
            temp.add(s);
        }
        return new Employees(temp);
    }
}
