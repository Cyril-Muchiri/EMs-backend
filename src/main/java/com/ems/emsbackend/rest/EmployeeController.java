package com.ems.emsbackend.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.emsbackend.entity.Employee;
import com.ems.emsbackend.services.EmployeeServiceI;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeServiceI employeeServiceI;

    @PostMapping(path = "/add-employee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServiceI.creatEmployee(employee), HttpStatus.OK);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeServiceI.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeServiceI.findEmployeeById(id);
    }

    @GetMapping("/email")
    public Employee getEmployeeByEmail(@RequestBody Employee employee) {
        return employeeServiceI.findByEmail(employee.getEmail());
    }

    @PutMapping
    public String updateDetails(@RequestBody Employee employee) {
        return employeeServiceI.updateDetails(employee);
    }

    @DeleteMapping
    public String deleteEmployee(@RequestBody Employee employee) {
        return employeeServiceI.deleteEmployeeByEmail(employee.getEmail());
    }

}
