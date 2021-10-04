package com.h2s.carpark.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTORequest {
    private String account;
    private String department;
    private String employeeAddress;
    private java.sql.Date employeeBirthdate;
    private String employeeEmail;
    private String employeeName;
    private String employeePhone;
    private String sex;
}
