package com.example.skyprohw25.service;

import com.example.skyprohw25.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName);

    abstract Employee add(String firstName, String lastName, double salary, int department);

    Employee remove(String firstName, String lastName, double salary, int department);
    Employee find(String firstName, String lastName, double salary, int department);

    Collection<Employee> findAll();
}
