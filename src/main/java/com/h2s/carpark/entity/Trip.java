package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "trip")
@Getter
@Setter
@ToString
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tripId")
    private Long tripId;

    @Column(name = "bookedTicketNumber")
    private Integer bookedTicketNumber;

    @Column(name = "carType")
    private String carType;

    @Column(name = "departureDate")
    private String departureDate;

    @Column(name = "departureTime")
    private Long departureTime;

    @Column(name = "destination")
    private String destination;

    @Column(name = "driver")
    private String driver;

    @Column(name = "maximumOnlineTicketNumber")
    private Integer maximumOnlineTicketNumber;

}
