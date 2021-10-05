package com.h2s.carpark.dto.response;

import com.h2s.carpark.entity.Bookingoffice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@ToString
public class TripResponse {
    private Integer bookedTicketNumber;
    private String carType;
    private Date departureDate;
    private Time departureTime;
    private String destination;
    private String driver;
    private Integer maximumOnlineTicketNumber;
}
