package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {
    @Id
    @Column(name = "licensePlate")
    private String licensePlate;

    @Column(name = "carColor")
    private String carColor;

    @Column(name = "carType")
    private String carType;

    @Column(name = "company")
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "park_id")
    private Parkinglot parkinglot;

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carType='" + carType + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
