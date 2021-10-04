package com.h2s.carpark.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkinglotDTORequest {
    private Long parkArea;
    private String parkName;
    private String parkPlace;
    private Long parkPrice;
    private String parkStatus;
}
