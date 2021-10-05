package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Getter
@Setter
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "licensePlate")
    private String licensePlate;

    @Column(name = "carColor")
    private String carColor;

    @Column(name = "carType")
    private String carType;

    @Column(name = "company")
    private String company;

}
