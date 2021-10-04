package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

    public Long getParkId() {
        return this.parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Long getParkArea() {
        return this.parkArea;
    }

    public void setParkArea(Long parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return this.parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return this.parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public Long getParkPrice() {
        return this.parkPrice;
    }

    public void setParkPrice(Long parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return this.parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }
}
