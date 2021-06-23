package com.example.SpringBootThymeleafCRUDwebapp.repository;

import com.example.SpringBootThymeleafCRUDwebapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This interface will inherits all JpaRepository methods we need
// for CRUD operations and more
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
