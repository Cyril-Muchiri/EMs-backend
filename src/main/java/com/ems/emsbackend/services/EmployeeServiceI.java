package com.ems.emsbackend.services;

import java.util.List;

import com.ems.emsbackend.entity.Employee;

public interface EmployeeServiceI {
    String creatEmployee (Employee employee);
    List<Employee> getAllEmployees();
    Employee findByEmail(String email);
    Employee findEmployeeById(Long id);
    String updateDetails(Employee employee);
    String deleteEmployeeByEmail(String email);

}
