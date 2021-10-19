/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.BookingofficeRequest;
import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.dto.response.TripResponse;
import com.h2s.carpark.entity.Bookingoffice;
import com.h2s.carpark.entity.Employee;
import com.h2s.carpark.entity.Trip;
import com.h2s.carpark.repository.BookingofficeRepository;
import com.h2s.carpark.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingofficeServiceImpl implements BookingofficeService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BookingofficeRepository bookingofficeRepository;

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<BookingofficeResponse> getAll() {
        List<Bookingoffice> bookingoffices = bookingofficeRepository.findAll();
        List<BookingofficeResponse> bookingofficeResponses = new ArrayList<>();
        for (Bookingoffice it : bookingoffices) {
            bookingofficeResponses.add(mapper.map(it,BookingofficeResponse.class));
        }
        return bookingofficeResponses;

    }

    @Override
    public BookingofficeResponse addBookingoffice(BookingofficeRequest bookingofficeRequest) {
        String tripId = bookingofficeRequest.getTripId();
        Optional<Trip> trip = tripRepository.findById(tripId);
        if(!trip.isPresent())
            return null;
        Bookingoffice bookingoffice = mapper.map(bookingofficeRequest,Bookingoffice.class);
        bookingoffice.setTrip(trip.get());
        Bookingoffice bookingoffice1 = bookingofficeRepository.save(bookingoffice);
        BookingofficeResponse bookingofficeResponse = mapper.map(bookingoffice1, BookingofficeResponse.class);
        return bookingofficeResponse;
    }

    @Override
    public ApiResponse updateBookingoffice(String id, BookingofficeRequest bookingofficeRequest) {
        Optional<Bookingoffice> bookingoffice = bookingofficeRepository.findById(id);
        Optional<Trip> trip = tripRepository.findById(bookingofficeRequest.getTripId());
        if(!bookingoffice.isPresent())
            return new ApiResponse(false, "Booking can't find");
        Bookingoffice result = mapper.map(bookingofficeRequest,Bookingoffice.class);
        Bookingoffice employeeResult = result;
        employeeResult.setOfficeId(bookingoffice.get().getOfficeId());
        employeeResult.setTrip(trip.get());
        try {
            Bookingoffice bookingofficeSave = bookingofficeRepository.save(result);
            return new ApiResponse(true,bookingofficeSave.toString());
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }

    @Override
    public ApiResponse deleteEmployee(String id) {
        try {
            bookingofficeRepository.deleteById(id);
            return new ApiResponse(true,"delete employee Success");
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }

}
