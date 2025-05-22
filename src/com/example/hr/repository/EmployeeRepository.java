package com.example.hr.repository;

import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.IdentityNo;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    boolean exist(IdentityNo identity);

    Employee createEmployee(Employee employee);

    Optional<Employee> removeEmployee(IdentityNo identity);

    Optional<Employee> findEmployeeByIdentityNo(IdentityNo identity);

    List<Employee> findAllEmployeesByDepartment(Department department);
}
