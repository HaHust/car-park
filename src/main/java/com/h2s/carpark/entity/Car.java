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

    @Column(name = "parkId")
    private Long parkId;

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return this.carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return this.carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getParkId() {
        return this.parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }
}
