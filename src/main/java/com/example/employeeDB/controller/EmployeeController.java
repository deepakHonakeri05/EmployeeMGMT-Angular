package com.example.employeeDB.controller;

import com.example.employeeDB.model.Employee;
import com.example.employeeDB.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //get All employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
