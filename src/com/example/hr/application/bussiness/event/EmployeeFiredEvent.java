package com.example.hr.application.bussiness.event;

import com.example.hr.domain.Employee;
import com.example.hr.domain.IdentityNo;

public class EmployeeFiredEvent extends EmployeeEvent {

    private final Employee employee;
    public EmployeeFiredEvent(Employee employee) {
        super(employee.getIdentity());
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
