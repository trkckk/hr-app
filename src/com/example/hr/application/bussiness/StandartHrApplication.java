package com.example.hr.application.bussiness;

import com.example.hr.application.HrApplication;
import com.example.hr.application.bussiness.event.EmployeeEvent;
import com.example.hr.application.bussiness.event.EmployeeFiredEvent;
import com.example.hr.application.bussiness.event.EmployeeHireEvent;
import com.example.hr.application.bussiness.event.SalaryChangedEvent;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.IdentityNo;
import com.example.hr.infra.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class StandartHrApplication implements HrApplication {

    private EmployeeRepository employeeRepository;
    private EventPublisher eventPublisher;

    public StandartHrApplication(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
        this.employeeRepository = employeeRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Optional<Employee> hireEmployee(Employee employee) {
        var identity = employee.getIdentity();
        if(employeeRepository.exist(identity))
            return Optional.empty();
        eventPublisher.publish(new EmployeeEvent(identity));
        return Optional.of(employeeRepository.createEmployee(employee));
    }

    @Override
    public Optional<Employee> fireEmployee(IdentityNo identity) {
        Optional<Employee> firedEmployee =
                employeeRepository.removeEmployee(identity);
        firedEmployee.ifPresent(
                emp -> eventPublisher.publish(new EmployeeFiredEvent(emp))
        );
        return firedEmployee;
    }

    @Override
    public Optional<Employee> getEmployeeInformation(IdentityNo identity) {

        return employeeRepository.findEmployeeByIdentityNo(identity);
    }

    @Override
    public List<Employee> increaseSalary(Department department, double rate) {
        var employees = employeeRepository.findAllEmployeesByDepartment(department);
        employees.forEach(employee -> {

            employee.setSalary(employee.getSalary().multiply(1.0 + rate));
            eventPublisher.publish(new SalaryChangedEvent(employee));
        });
        return employees;
    }
}
