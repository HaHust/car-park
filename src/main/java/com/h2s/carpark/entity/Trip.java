package com.h2s.carpark.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "trip_id")
    private String tripId;

    @Column(name = "booked_ticket_number")
    private Integer bookedTicketNumber;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "departure_date")
    private java.sql.Date departureDate;

    @Column(name = "departuret_time")
    private java.sql.Time departureTime;

    @Column(name = "destination")
    private String destination;

    @Column(name = "driver")
    private String driver;

    @Column(name = "maximum_online_ticket_number")
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
