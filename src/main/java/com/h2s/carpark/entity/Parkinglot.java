package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parkinglot")
@Getter
@Setter
@ToString
public class Parkinglot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parkId")
    private Long parkId;

    @Column(name = "parkArea")
    private Long parkArea;

    @Column(name = "parkName")
    private String parkName;

    @Column(name = "parkPlace")
    private String parkPlace;

    @Column(name = "parkPrice")
    private Long parkPrice;

    @Column(name = "parkStatus")
    private String parkStatus;

    @OneToMany(mappedBy = "parkinglot",
            fetch = FetchType.LAZY)
    private List<Car> cars;
}
