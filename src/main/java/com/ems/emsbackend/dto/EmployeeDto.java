package com.ems.emsbackend.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.emsbackend.entity.Employee;

@Repository
public interface EmployeeDto extends JpaRepository<Employee,Long> {
    Employee findByEmail(String email);
    String deleteByEmail(String email);
}
