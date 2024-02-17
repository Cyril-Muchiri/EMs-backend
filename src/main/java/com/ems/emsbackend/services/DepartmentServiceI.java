package com.ems.emsbackend.services;

import java.util.List;
import com.ems.emsbackend.entity.Department;

public interface DepartmentServiceI {
    Department creaDepartment(Department department);

    List<Department> getDepartments();

    Department getById(Long id);

    Department getByName(String name);

    Department updateDepartment(Department department);

    // String deleteDepartment(Department department);
    public String deleteDepartment(long id);

}
