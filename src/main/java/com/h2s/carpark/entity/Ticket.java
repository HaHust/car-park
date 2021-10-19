package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@ToString
public class Ticket {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name = "booking_time")
    private java.sql.Time bookingTime;

    @Column(name = "customer_name")
    private String customerName;
}
