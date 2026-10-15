
package com.employee.bean;

public class Employee {

    private int emp_Id;
    private String emp_Name;
    private Double salary;

    public Employee() {
    }

    public Employee(int emp_Id, String emp_Name, Double salary) {
        this.emp_Id = emp_Id;
        this.emp_Name = emp_Name;
        this.salary = salary;
    }

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}