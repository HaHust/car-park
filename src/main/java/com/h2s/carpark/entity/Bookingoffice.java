package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "bookingoffice")
@Getter
@Setter
@ToString
public class Bookingoffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officeId")
    private Long officeId;

    @Column(name = "endContractDeadline")
    private java.sql.Date endContractDeadline;

    @Column(name = "officeName")
    private String officeName;

    @Column(name = "officePhone")
    private String officePhone;

    @Column(name = "officePlace")
    private String officePlace;

    @Column(name = "officePrice")
    private Long officePrice;

    @Column(name = "startContractDeadline")
    private java.sql.Date startContractDeadline;

    @Column(name = "tripId")
    private Long tripId;
}
