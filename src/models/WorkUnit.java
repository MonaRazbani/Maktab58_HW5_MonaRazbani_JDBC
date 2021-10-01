package models;

import java.util.ArrayList;
import java.util.List;

public class WorkUnit {
    private int id ;
    private String name ;
    private String phone ;
    private List<Employee> employeeList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name +
                ", phone='" + phone +
                ", employeeList=" + employeeList +
                '}';
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
