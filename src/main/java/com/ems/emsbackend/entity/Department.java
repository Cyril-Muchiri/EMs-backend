package com.ems.emsbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // declare jpa entity class
@Getter // use lombok to create getter methods
@Setter // use lombok to create setter methods
@NoArgsConstructor //use lombok to create empty constructor
@AllArgsConstructor // use lombok to create paramentrized constructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String departmentName;

    @Column(nullable = false)
    private String departmentDescription;
}
