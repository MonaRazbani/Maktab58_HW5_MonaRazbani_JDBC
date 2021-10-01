package dataBaseAccess;

import models.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDataBase {

    private Connection connection;
    public EmployeeDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/maktab58_HW5_jdbc", "mona_razbani", "Pendi_Pengi142131");
    }

    public Connection getConnection() {
        return connection;
    }

    public int save(Employee employee) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuery = String.format("INSERT INTO employee (first_name, last_name , employee_number ) VALUES ('%s','%s','%d)", employee.getFirst_name(), employee.getLast_name(), employee.getEmployee_number());
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

