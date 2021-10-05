/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.TripRequest;
import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.dto.response.EmployeeResponse;
import com.h2s.carpark.dto.response.TripResponse;
import com.h2s.carpark.entity.Bookingoffice;
import com.h2s.carpark.entity.Employee;
import com.h2s.carpark.entity.Trip;
import com.h2s.carpark.repository.BookingofficeRepository;
import com.h2s.carpark.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<TripResponse> getAll() {
        List<Trip> trips = tripRepository.findAll();
        List<TripResponse> tripResponses = new ArrayList<>();
        for (Trip it : trips) {
            tripResponses.add(mapper.map(it,TripResponse.class));
        }
        return tripResponses;
    }

    @Override
    public TripResponse addTrip(TripRequest tripRequest) {
        Trip trip = mapper.map(tripRequest,Trip.class);
        trip.setBookedTicketNumber(0);
        Trip trip1 = tripRepository.save(trip);
        TripResponse tripResponse = mapper.map(trip1, TripResponse.class);
        return tripResponse;
    }

    @Override
    public ApiResponse updateTrip(Long id, TripRequest tripRequest) {
        Optional<Trip> trip = tripRepository.findById(id);
        if(!trip.isPresent())
            return new ApiResponse(false, "Employee can't find");
        Trip result = mapper.map(tripRequest,Trip.class);
        result.setTripId(trip.get().getTripId());
        result.setBookedTicketNumber(trip.get().getBookedTicketNumber());

        try {
            Trip tripSave = tripRepository.save(result);
            return new ApiResponse(true,mapper.map(tripSave,TripResponse.class).toString());
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }

    @Override
    public ApiResponse deleteTrip(Long id) {
        try {
            tripRepository.deleteById(id);
            return new ApiResponse(true,"delete employee Success");
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }
}
