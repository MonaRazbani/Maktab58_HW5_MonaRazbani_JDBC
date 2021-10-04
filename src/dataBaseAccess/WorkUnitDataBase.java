package dataBaseAccess;

import models.Employee;
import models.WorkUnit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
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

    public WorkUnit findWorkUnitByName(String name ) throws SQLException {
        WorkUnit workUnit =null;
        if (getConnection()!=null ){
            Statement statement= getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery(String.format("select name and phone from work_unit  where name = '%s'",name));
            while (resultSet.next()){
                String workUnitName = resultSet.getString(2);
                String phone= resultSet.getString(3);
                workUnit.setName(workUnitName);
                workUnit.setPhone(phone);


            }
        }
        return workUnit ;
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

    public boolean ubdateName (String newName , String currentName  ) throws SQLException {
        if (getConnection()!=null){
            int workUnitID = findUnitIDByName(currentName);
            if (workUnitID > 0 ) {
                Statement statement =getConnection().createStatement();
                String sql = String.format("update work_unit set name = '%s' where name = '%S ' " , newName ,currentName);
                int result = statement.executeUpdate(sql);
                if(result > 0 ){
                    return true ;
                }
            }
        }
        return false;
    }

    public List<WorkUnit> displayWorkUnit () throws SQLException {
        if (getConnection() != null) {
            List<WorkUnit> workUnitList = new ArrayList<>();
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from work_unit");
            while (resultSet.next()) {
                WorkUnit workUnit = new WorkUnit();
                workUnit.setName(resultSet.getString(2));
                workUnit.setPhone(resultSet.getString(3));
                workUnitList.add(workUnit);
            }
            return workUnitList;
        } else {
            return Collections.emptyList();
        }
    }
}


