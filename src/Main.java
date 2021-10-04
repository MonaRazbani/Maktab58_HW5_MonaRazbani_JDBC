

import dataBaseAccess.*;
import java.sql.Date;
import java.sql.SQLException;
import models.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws SQLException, ClassNotFoundException {
        EmployeeDataBase employeeDao = new EmployeeDataBase();
        WorkUnitDataBase workUnitDao = new WorkUnitDataBase();

        System.out.println("enter your Action : 1: insert new Employee \n 2: insert new work unit \n" +
                " 3: update employee 's  first name & last name \n 4: update work unit name \n " +
                " 5: show employees info \n 6: show work units info ");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        while (true){
            switch (type) {
                case 1:{
                    System.out.println("enter first_name, last_name, Date birthday_date,  employee_number, WorkUnit name  ");
                    String info = scanner.next();
                    String[] arrInfo = info.split(",", 5);
                    String firstName = arrInfo[0];
                    String lastName = arrInfo[1];
                    Date birthday = Date.valueOf(arrInfo[2]);
                    double employeeNum = Double.parseDouble(arrInfo[4]);
                    String name = arrInfo[5];
                    WorkUnit workUnit = workUnitDao.findWorkUnitByName(name);
                    Employee employee = new Employee(firstName, lastName, birthday, employeeNum, workUnit);
                    employeeDao.save(employee);
                    workUnit.getEmployeeList().add(employee);
                    workUnitDao.updateEmployeeList(workUnit);

                    break;
            }
                  case 2:{
                System.out.println("enter name, phone  ");
                String info = scanner.next();
                String[] arrInfo = info.split(",", 2);
                String name = arrInfo[0];
                String phone  = arrInfo[1];
                WorkUnit workUnit = new WorkUnit(name,phone);
                workUnitDao.save(workUnit);
                break ;
            }
                case 3: {
                    System.out.println("enter  currentFirstName ,currentLastName,new first_name,  new last_name ");
                    String info = scanner.next();
                    String[] arrInfo = info.split(",", 4);
                    String newFirstName = arrInfo[3];
                    String newLastName = arrInfo[4];
                    String currentFirstName = arrInfo[0];
                    String currentLastName = arrInfo[1];
                    if (employeeDao.ubdateName(newFirstName, newLastName, currentFirstName, currentLastName)) {
                        System.out.println("done ");
                    } else System.out.println("something wrong");
                    break;
                }
                case 4: {
                    System.out.println("enter  current Name,new name ");
                    String info = scanner.next();
                    String[] arrInfo = info.split(",", 2);
                    String currentName = arrInfo[0];
                    String newName = arrInfo[1];
                    if (workUnitDao.ubdateName(newName,currentName)) {
                        System.out.println("done ");
                    } else System.out.println("something wrong");
                    break;
                }
                case 5 :{
                    System.out.println(employeeDao.displayEmployee());
                    break;
                }
                case 6 :{
                    System.out.println(workUnitDao.displayWorkUnit());
                    break;
                }
                default: {
                    System.out.println("wrong number");
                    break;
                }
            }
        }
    }
}
