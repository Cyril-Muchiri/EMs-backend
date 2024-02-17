package com.ems.emsbackend.services;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ems.emsbackend.dto.EmployeeDto;
import com.ems.emsbackend.entity.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService implements EmployeeServiceI {

    private EmployeeDto employeeDto;

    @Override
    public String creatEmployee(Employee employee) {

        String msg = "";
            try {
                employeeDto.save(employee);
                msg = "Employee added succesfully!";
            } catch (DataAccessException e) {
                msg = " cannot perfom operation!";
            }
        
        return msg;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDto.findAll();
    }

    @Override
    public Employee findByEmail(String email) {
       // Employee employee = employeeDto.findByEmail(email) != null ? employeeDto.findByEmail(email) : null;
       Employee employee = employeeDto.findByEmail(email);
       System.out.println(employee);
        return employee;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Employee employee = employeeDto.findById(id).orElse(null);
        System.out.println(employee);
        return employee;
    }

    @Override
    public String updateDetails(Employee employee) {

        String msg = "";

        if (employeeDto.findById(employee.getId()).isPresent()) {
            employeeDto.save(employee);
            msg = "Update successfull for :" + employee.getId();
        } else {
            msg = "Operation cannot be performed";
        }

        return msg;
    }

    @Override
    public String deleteEmployeeByEmail(String email) {
        String msg = "";

        if (employeeDto.findByEmail(email) != null) {
            employeeDto.deleteByEmail(email);
            msg = "Delete successfull";
        } else {
            msg = "Operation cannot be perfomed";
        }

        return msg;
    }

}
