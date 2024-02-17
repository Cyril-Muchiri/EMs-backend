package com.ems.emsbackend.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.emsbackend.entity.Department;

@Repository
public interface DepartmentDto extends JpaRepository<Department,Long>{
    Department findBydepartmentName(String departmentName);
}

