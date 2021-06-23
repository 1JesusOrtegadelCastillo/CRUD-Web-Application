package com.example.SpringBootThymeleafCRUDwebapp.service;

import com.example.SpringBootThymeleafCRUDwebapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    // Retrieve all employees
    List<Employee> getAllEmployees();
    // Save/Create new employee
    void saveEmployee(Employee employee);
    // Update employee
    Employee getEmployeeById(int id);
    // Delete employee
    void deleteEmployeeById(int id);
}
