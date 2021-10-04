package com.h2s.carpark.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingofficeDTORequest {

    private java.sql.Date endContractDeadline;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private Long officePrice;
    private java.sql.Date startContractDeadline;

}
