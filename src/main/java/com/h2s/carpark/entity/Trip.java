package com.h2s.carpark.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
@Getter
@Setter
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
    private java.sql.Date departureDate;

    @Column(name = "departureTime")
    private java.sql.Time departureTime;

    @Column(name = "destination")
    private String destination;

    @Column(name = "driver")
    private String driver;

    @Column(name = "maximumOnlineTicketNumber")
    private Integer maximumOnlineTicketNumber;

    @OneToMany(mappedBy = "trip",
            fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Bookingoffice> bookingoffice_list;

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", bookedTicketNumber=" + bookedTicketNumber +
                ", carType='" + carType + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", destination='" + destination + '\'' +
                ", driver='" + driver + '\'' +
                ", maximumOnlineTicketNumber=" + maximumOnlineTicketNumber +
                '}';
    }
}
