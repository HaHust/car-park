package com.h2s.carpark.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingofficeDTOResponse {
    private java.sql.Date endContractDeadline;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private Long officePrice;
    private java.sql.Date startContractDeadline;

}
