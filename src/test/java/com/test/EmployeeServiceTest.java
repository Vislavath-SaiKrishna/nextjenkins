
package com.test;
import com.employee.bean.Employee;
import com.employee.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee(1, "Rahul", 45000.0);

        Employee result = employeeService.addEmployee(employee);

        assertNotNull(result);
        assertEquals(1, result.getEmp_Id());
        assertEquals("Rahul", result.getEmp_Name());
        assertEquals(45000.0, result.getSalary());
    }

    @Test
    void testGetAllEmployees() {
        employeeService.addEmployee(new Employee(1, "Rahul", 45000.0));
        employeeService.addEmployee(new Employee(2, "Priya", 50000.0));

        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(2, employees.size());
    }

    @Test
    void testGetEmployeeById() {
        employeeService.addEmployee(new Employee(1, "Rahul", 45000.0));

        Employee result = employeeService.getEmployeeById(1);

        assertNotNull(result);
        assertEquals("Rahul", result.getEmp_Name());
    }

    @Test
    void testGetEmployeeByIdNotFound() {
        Employee result = employeeService.getEmployeeById(99);

        assertNull(result);
    }

    @Test
    void testUpdateEmployee() {
        employeeService.addEmployee(new Employee(1, "Rahul", 45000.0));

        Employee updatedEmployee = new Employee(1, "Rahul Kumar", 55000.0);
        Employee result = employeeService.updateEmployee(1, updatedEmployee);

        assertNotNull(result);
        assertEquals("Rahul Kumar", result.getEmp_Name());
        assertEquals(55000.0, result.getSalary());
    }

    @Test
    void testUpdateEmployeeNotFound() {
        Employee updatedEmployee = new Employee(99, "Amit", 60000.0);

        Employee result = employeeService.updateEmployee(99, updatedEmployee);

        assertNull(result);
    }

    @Test
    void testDeleteEmployee() {
        employeeService.addEmployee(new Employee(1, "Rahul", 45000.0));

        boolean result = employeeService.deleteEmployee(1);

        assertTrue(result);
        assertNull(employeeService.getEmployeeById(1));
    }

    @Test
    void testDeleteEmployeeNotFound() {
        boolean result = employeeService.deleteEmployee(99);

        assertFalse(result);
    }
}