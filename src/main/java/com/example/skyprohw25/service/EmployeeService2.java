package com.example.skyprohw25.service;


import com.example.skyprohw25.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService2 {
    private static final int SIZE = 5;
    private Employee[] staff = new Employee[SIZE];

    EmployeeService2() {
        staff[0] = new Employee("Василий", "Васильев", 50000, 5);
        staff[1] = new Employee("Виктор", "Генкин", 51000, 5);
        staff[2] = new Employee("Валерий", "Буров", 52000, 5);
        staff[3] = new Employee("Геннадий", "Букин", 53000, 5);
        staff[4] = new Employee("Георгий", "Гренкин", 54000, 5);
    }

    public Employee getMaxPaidByDept (int department) {
        return Arrays.stream(staff)
                .filter(e -> e != null)
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Department number not found"));
    }

    public Employee getMinPaidByDept (int department) {
        return Arrays.stream(staff)
                .filter(e -> e != null)
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Department number not found"));
    }

    public List<Employee> showAll () {
        return Arrays.stream(staff)
                .filter(e -> e != null)
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }

    public List<Employee> showByDept (int id) {
        return Arrays.stream(staff)
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
    }


}
