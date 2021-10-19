package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parkinglot")
@Getter
@Setter
@ToString
public class Parkinglot {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "park_id")
    private String parkId;

    @Column(name = "park_area")
    private Long parkArea;

    @Column(name = "park_name")
    private String parkName;

    @Column(name = "park_place")
    private String parkPlace;

    @Column(name = "park_price")
    private Long parkPrice;

    @Column(name = "park_status")
    private String parkStatus;

    @OneToMany(mappedBy = "parkinglot",
            fetch = FetchType.LAZY)
    private List<Car> cars;
}
