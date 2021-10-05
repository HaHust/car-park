package com.h2s.carpark.repository;

import com.h2s.carpark.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    Optional<Car> findCarByLicensePlate(String LicensePlate);
}