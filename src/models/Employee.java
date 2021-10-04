package models;
import java.sql.Date;

public class Employee {
 private String first_name;
 private String last_name;
 private Date birthday_date;
 private double employee_number;
 private WorkUnit workUnit;

 public Employee() {
   }

 public Employee(String first_name, String last_name, Date birthday_date, double employee_number, WorkUnit workUnit) {
  this.first_name = first_name;
  this.last_name = last_name;
  this.birthday_date = birthday_date;
  this.employee_number = employee_number;
  this.workUnit = workUnit;
 }

 public String getFirst_name() {
  return first_name;
 }

 public void setFirst_name(String first_name) {
  this.first_name = first_name;
 }

 public String getLast_name() {
  return last_name;
 }

 public void setLast_name(String last_name) {
  this.last_name = last_name;
 }

 public Date getBirthday_date() {
  return birthday_date;
 }

 public void setBirthday_date(Date birthday_date) {
  this.birthday_date = birthday_date;
 }

 public double getEmployee_number() {
  return employee_number;
 }

 public void setEmployee_number(double employee_number) {
  this.employee_number = employee_number;
 }

 public WorkUnit getWorkUnit() {
  return workUnit;
 }

 @Override
 public String toString() {
  return "Employee{" +
          "first_name='" + first_name  +
          ", last_name='" + last_name +
          ", birthday_date=" + birthday_date +
          ", employee_number=" + employee_number +
          ", workUnit=" + workUnit +
          '}';
 }

 public void setWorkUnit(WorkUnit workUnit) {
  this.workUnit = workUnit;
 }
}

