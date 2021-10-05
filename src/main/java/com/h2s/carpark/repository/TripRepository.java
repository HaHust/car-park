package com.h2s.carpark.repository;

import com.h2s.carpark.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT DISTINCT t FROM Trip t INNER JOIN FETCH t.bookingoffice_list ")
    Trip queryTrip();
}