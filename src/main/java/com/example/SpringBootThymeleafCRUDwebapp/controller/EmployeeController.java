package com.example.SpringBootThymeleafCRUDwebapp.controller;

import com.example.SpringBootThymeleafCRUDwebapp.entity.Employee;
import com.example.SpringBootThymeleafCRUDwebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    // Create method handler for home page (index.html)

    @Autowired
    private EmployeeService employeeService;

    //Display a list of employees
    @GetMapping(path = "/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }

    // Creating model attribute to bind data
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        // Thymeleaf template will access this empty employee object
        // for binding data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping(path = "/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save new employee into the database
        employeeService.saveEmployee(employee);
        return "redirect:/"; // redirecting to viewHomePage
    }

    @GetMapping(path = "/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model){
        // getting employee from the service
        Employee employee = employeeService.getEmployeeById(id);
        // setting employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "/update_employee";
    }

    @GetMapping(path = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") int id){
        //Calling delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

}
