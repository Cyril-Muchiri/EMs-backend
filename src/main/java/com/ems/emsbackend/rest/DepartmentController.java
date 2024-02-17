package com.ems.emsbackend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.emsbackend.entity.Department;
import com.ems.emsbackend.services.DepartmentServiceI;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceI departmentServiceI;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department newDepartment) {
        Department department = departmentServiceI.creaDepartment(newDepartment);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Department> getAllDeaprtments() {
        return departmentServiceI.getDepartments();
    }

    @GetMapping("/get/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentServiceI.getById(id);
    }

    @GetMapping("/get/name/{name}")
    public Department getDepartment(@PathVariable String name) {
        return departmentServiceI.getByName(name);
    }

    @PutMapping
    public Department updateDepartment(@RequestBody Department department) {
        return departmentServiceI.updateDepartment(department);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable Long id) {
        String status = departmentServiceI.deleteDepartment(id);

        return new ResponseEntity<String>(status, HttpStatus.ACCEPTED);
    }

}
