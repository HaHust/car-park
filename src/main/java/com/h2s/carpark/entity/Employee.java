package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "account")
    private String account;

    @Column(name = "department")
    private String department;

    @Column(name = "employee_address")
    private String employeeAddress;

    @Column(name = "employee_birthdate")
    private java.sql.Date employeeBirthdate;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_phone")
    private String employeePhone;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private String sex;
}
