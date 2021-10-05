package com.h2s.carpark.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequest {
    private java.sql.Time bookingTime;
    private String customerName;
}
