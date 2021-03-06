package com.h2s.carpark.dto.response;

import com.h2s.carpark.entity.Trip;
import com.h2s.carpark.repository.TripRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingofficeResponse {
    private java.sql.Date endContractDeadline;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private Long officePrice;
    private java.sql.Date startContractDeadline;
}
