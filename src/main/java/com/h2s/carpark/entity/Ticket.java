package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketId")
    private Long ticketId;

    @Column(name = "bookingTime")
    private java.sql.Time bookingTime;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "licensePlate")
    private String licensePlate;

    @Column(name = "tripId")
    private Long tripId;
}
