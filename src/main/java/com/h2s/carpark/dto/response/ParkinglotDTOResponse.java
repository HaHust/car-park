package com.h2s.carpark.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkinglotDTOResponse {
    private Long parkArea;
    private String parkName;
    private String parkPlace;
    private Long parkPrice;
    private String parkStatus;

}
