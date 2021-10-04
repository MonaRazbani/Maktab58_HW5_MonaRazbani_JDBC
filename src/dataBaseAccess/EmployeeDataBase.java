package dataBaseAccess;

import models.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDataBase extends DataBaseAccess{

    public EmployeeDataBase() throws ClassNotFoundException, SQLException {
        super();
    }

    public int save(Employee employee) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuery = String.format("INSERT INTO employee (first_name, last_name , employee_number ,birthday , work_unit_fk ) VALUES ('%s','%s','%d ,%tF, %d )", employee.getFirst_name(), employee.getLast_name(), employee.getEmployee_number(), employee.getBirthday_date(),employee.getWorkUnit());
            int i = statement.executeUpdate(sqlQuery);
            return i;
        } else {
            return 0;
        }
    }

    public List<Employee> displayEmployee () throws SQLException  {
        if (getConnection() != null) {
            List<Employee> employeeList = new ArrayList<>();
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                 Employee employee= new Employee();
                 employee.setFirst_name(resultSet.getString("first_name"));
                 employee.setLast_name (resultSet.getString("last_name"));
                 employeeList.add(employee);
            }
            return employeeList;
        } else {
            return Collections.emptyList();
        }
    }
}

