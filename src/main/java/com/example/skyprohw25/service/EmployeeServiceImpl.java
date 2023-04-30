package com.example.skyprohw25.service;

import com.example.skyprohw25.exception.EmployeeAlreadyAddedException;
import com.example.skyprohw25.exception.EmployeeNotFoundException;
import com.example.skyprohw25.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public abstract class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl (ValidatorService validatorService) {
        this.validatorService = validatorService;
        this.employees = new HashMap<>(); }

    private final ValidatorService validatorService;

    public EmployeeServiceImpl(Map<String, Employee> employees, ValidatorService validatorService) {
        this.employees = employees;
        this.validatorService = validatorService;
    }

    @Override
    public Employee add(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName,
                lastName,
                salary,
                department);
        if(employees.containsKey(employee.fullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.fullName(), employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if(employees.containsKey(employee.fullName())) {
            return employees.remove(employee.fullName());
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Employee find (String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if(employees.containsKey(employee.fullName())) {
            return employees.remove(employee.fullName());
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
