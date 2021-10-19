package com.h2s.carpark.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequest {
    private String licensePlate;
    private String carColor;
    private String carType;
    private String company;
    private String parkId;
}
