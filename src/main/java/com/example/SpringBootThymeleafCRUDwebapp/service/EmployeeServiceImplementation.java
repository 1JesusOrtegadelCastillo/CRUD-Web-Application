package com.example.SpringBootThymeleafCRUDwebapp.service;

import com.example.SpringBootThymeleafCRUDwebapp.entity.Employee;
import com.example.SpringBootThymeleafCRUDwebapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    @Autowired // Injecting our repository (to obtain JpaRepository methods)
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    // method for save new employee using a button
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    // Updating existing employee
    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    // Implementing delete method
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
