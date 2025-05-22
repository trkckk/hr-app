package com.example.hr.application.bussiness.event;

import com.example.hr.domain.Employee;
import com.example.hr.domain.IdentityNo;
import com.example.hr.domain.Money;

public class SalaryChangedEvent extends EmployeeEvent {
    private final Money salary;

    public SalaryChangedEvent(Employee employee) {
        super(employee.getIdentity());
        this.salary = employee.getSalary();
    }

    public Money getSalary() {
        return salary;
    }
}
