package com.h2s.carpark.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private Long employeeId;

    @Column(name = "account")
    private String account;

    @Column(name = "department")
    private String department;

    @Column(name = "employeeAddress")
    private String employeeAddress;

    @Column(name = "employeeBirthdate")
    private java.sql.Date employeeBirthdate;

    @Column(name = "employeeEmail")
    private String employeeEmail;

    @Column(name = "employeeName")
    private String employeeName;

    @Column(name = "employeePhone")
    private String employeePhone;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private String sex;

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeAddress() {
        return this.employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public java.sql.Date getEmployeeBirthdate() {
        return this.employeeBirthdate;
    }

    public void setEmployeeBirthdate(java.sql.Date employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public String getEmployeeEmail() {
        return this.employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return this.employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
