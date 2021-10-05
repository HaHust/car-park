package com.h2s.carpark.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class TicketResponse {
    private java.sql.Time bookingTime;
    private String customerName;
}
