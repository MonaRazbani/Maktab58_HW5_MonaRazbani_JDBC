package dataBaseAccess;

import models.Employee;
import models.WorkUnit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import java.sql.SQLException;
import java.sql.Statement;

public class WorkUnitDataBase extends DataBaseAccess{
    public WorkUnitDataBase() throws ClassNotFoundException, SQLException {
        super();
    }
    public int save(WorkUnit workUnit) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuery = String.format("INSERT INTO work_unit (name , phone  ) VALUES ('%s , %d ')", workUnit.getName(),workUnit.getPhone());
            int i = statement.executeUpdate(sqlQuery);
            return i;
        } else {
            return 0;
        }
    }
    public int findUnitIDByName(String name ) throws SQLException {
        int id = -1 ;
        if (getConnection()!=null ){
           Statement statement= (Statement) getConnection().createStatement();
           ResultSet resultSet= statement.executeQuery(String.format("select id from where name = '%s'",name));
            while (resultSet.next()){
               id = resultSet.getInt(1);

            }
        }
        return id ;
    }
    public boolean updateEmployeeList (WorkUnit workUnit) throws SQLException {
        int workUnitID = findUnitIDByName(workUnit.getName());
        if (workUnitID>0 ) {
            List<Employee> employees = workUnit.getEmployeeList();
            if (getConnection() != null) {
                int sum = 0;
                for (Employee employee : employees) {
                    Statement statement = getConnection().createStatement();
                    String sql = String.format(
                            "update employee set work_unit_fk = '%d' where first_name = '%s and last_name = '%s "
                            , workUnitID, employee.getFirst_name(), employee.getLast_name());
                    sum = statement.executeUpdate(sql);

                }
                return sum > 0;
            }
        }
            return false ;
        }

    }


