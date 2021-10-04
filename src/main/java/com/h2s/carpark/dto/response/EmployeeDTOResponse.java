package com.h2s.carpark.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTOResponse {
    private String account;
    private String department;
    private String employeeAddress;
    private java.sql.Date employeeBirthdate;
    private String employeeEmail;
    private String employeeName;
    private String employeePhone;
    private String sex;

}
