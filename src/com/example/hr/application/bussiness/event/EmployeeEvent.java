package com.example.hr.application.bussiness.event;



import com.example.hr.domain.IdentityNo;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeEvent {
    private static AtomicLong counter = new AtomicLong();
    private final String eventId;
    private final ZonedDateTime dateTime;
    private final long orderId;
    private final IdentityNo identityNo;

    public EmployeeEvent(IdentityNo identityNo) {
        eventId = UUID.randomUUID().toString();
        dateTime = ZonedDateTime.now();
        orderId = counter.incrementAndGet();
        this.identityNo = identityNo;

    }

    public String getEventId() {
        return eventId;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public long getOrderId() {
        return orderId;
    }

    public IdentityNo getIdentityNo() {
        return identityNo;
    }
}
