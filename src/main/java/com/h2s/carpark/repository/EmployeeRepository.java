package com.h2s.carpark.repository;

import com.h2s.carpark.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select e from Employee e where e.account like ?1%")
    public List<Employee> searchByAccount(String account);

    public Employee findByAccount(String account);

}