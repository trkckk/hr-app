package com.example.hr.application;

import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;

import com.example.hr.domain.IdentityNo;

import java.util.List;
import java.util.Optional;

public interface HrApplication {
    Optional<Employee> hireEmployee(Employee employee);
    Optional<Employee> fireEmployee(IdentityNo identity);
    Optional<Employee> getEmployeeInformation(IdentityNo identity);
    List<Employee> increaseSalary(Department department, double rate);

}
