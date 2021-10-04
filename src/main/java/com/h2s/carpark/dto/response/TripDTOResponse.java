package com.h2s.carpark.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripDTOResponse {
    private Integer bookedTicketNumber;
    private String carType;
    private String departureDate;
    private Long departureTime;
    private String destination;
    private String driver;
    private Integer maximumOnlineTicketNumber;

}
