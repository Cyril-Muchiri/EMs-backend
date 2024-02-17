package com.ems.emsbackend.services;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ems.emsbackend.dto.DepartmentDto;
import com.ems.emsbackend.entity.Department;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentService implements DepartmentServiceI {

    private DepartmentDto departmentDto;

    @Override
    public Department creaDepartment(Department department) {
        Department createDepartment = departmentDto.save(department);
        return createDepartment;
    }

    @Override
    public List<Department> getDepartments() {
        List<Department> allDepartmnets = departmentDto.findAll();
        return allDepartmnets;

    }

    @Override
    public Department getById(Long id) {
        Department fetchedDepartment = departmentDto.findById(id).orElse(null);
        return fetchedDepartment;
    }

    @Override
    public Department getByName(String name) {
        return departmentDto.findBydepartmentName(name);
    }

    @Override
    public Department updateDepartment(Department department) {
        Department departmentUpdate = departmentDto.save(department);

        return departmentUpdate;
    }

    @Override
    public String deleteDepartment(long id) {

        String msg = "";
        if ((departmentDto.findById(id).orElse(null))!=null) {
            departmentDto.deleteById(id);
            msg = "delete complete";
        } else {
            msg = "invalid operation";
        }
        return msg;
    }

}
