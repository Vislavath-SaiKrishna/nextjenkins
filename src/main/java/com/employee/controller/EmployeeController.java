
package com.employee.controller;

import com.employee.bean.Employee;
import com.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.addEmployee(employee));
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{emp_Id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int emp_Id) {
        Employee employee = employeeService.getEmployeeById(emp_Id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{emp_Id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable int emp_Id,
            @RequestBody Employee employee) {

        Employee updatedEmployee =
                employeeService.updateEmployee(emp_Id, employee);

        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{emp_Id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int emp_Id) {
        if (employeeService.deleteEmployee(emp_Id)) {
            return ResponseEntity.ok("Employee deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Employee not found");
    }
}