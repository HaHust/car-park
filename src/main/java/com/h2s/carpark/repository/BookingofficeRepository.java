package com.h2s.carpark.repository;

import com.h2s.carpark.entity.Bookingoffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingofficeRepository extends JpaRepository<Bookingoffice, String> {
}