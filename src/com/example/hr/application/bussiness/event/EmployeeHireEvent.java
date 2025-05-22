package com.example.hr.application.bussiness.event;

import com.example.hr.domain.IdentityNo;

public class EmployeeHireEvent extends EmployeeEvent{

    public EmployeeHireEvent(IdentityNo identityNo) {
        super(identityNo);

    }
}
