package com.example.employeeDB.service;

import com.example.employeeDB.exception.ResourceNotFoundException;
import com.example.employeeDB.model.Employee;
import com.example.employeeDB.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public ResponseEntity<Employee> getEmployeeById(Long id) {
        return ResponseEntity.ok(employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with Id : " + id + "is not Found")));
    }

    public ResponseEntity<Employee> updateEmployee(Long id, Employee newEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with Id : " + id + "is not Found"));
        employee.setFname(newEmployee.getFname());
        employee.setLname(newEmployee.getLname());
        employee.setEmailId(newEmployee.getEmailId());

        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with Id : " + id + "is not Found"));
        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted", true);
        return ResponseEntity.ok(response);
    }
}
