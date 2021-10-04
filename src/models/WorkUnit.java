package models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WorkUnit {
    private String name ;
    private String phone ;
    private List<Employee> employeeList = new ArrayList<>();

    public WorkUnit() {
    }

    public WorkUnit(String name) {
        this.name = name;
    }

    public WorkUnit(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public String toString() {
        return "WorkUnit{" +
                ", name='" + name +
                ", phone='" + phone +
                ", employeeList=" + employeeList +
                '}';
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
