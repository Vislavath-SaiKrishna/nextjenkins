
package com.employee.service;

import com.employee.bean.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int emp_Id) {
        return employees.stream()
                .filter(e -> e.getEmp_Id() == emp_Id)
                .findFirst()
                .orElse(null);
    }

    public Employee updateEmployee(int emp_Id, Employee updatedEmployee) {
        Employee employee = getEmployeeById(emp_Id);

        if (employee == null) {
            return null;
        }

        employee.setEmp_Name(updatedEmployee.getEmp_Name());
        employee.setSalary(updatedEmployee.getSalary());

        return employee;
    }

    public boolean deleteEmployee(int emp_Id) {
        return employees.removeIf(e -> e.getEmp_Id() == emp_Id);
    }
}