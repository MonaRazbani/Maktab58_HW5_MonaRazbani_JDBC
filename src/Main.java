import dataBaseAccess.EmployeeDataBase;
import models.Employee;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args)throws SQLException, ClassNotFoundException {
        EmployeeDataBase employeeDao = new EmployeeDataBase();
        Employee neda  = new Employee("neda ","akbari",null,123, null);

        int savedCount = employeeDao.save(neda);
        System.out.println(savedCount + " item(s) saved in database");
        List<Employee> employeeList = employeeDao.displayEmployee();
        for(Employee employee: employeeList)
            System.out.println(employee.toString());


    }
}
