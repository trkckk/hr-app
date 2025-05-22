package com.example.hr.infra;

import com.example.hr.application.bussiness.event.EmployeeEvent;
import com.example.hr.application.bussiness.event.EmployeeHireEvent;

public interface EventPublisher {
    void publish(EmployeeEvent employeeEvent);
}
