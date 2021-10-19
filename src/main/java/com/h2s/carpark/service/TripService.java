/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.EmployeeRequest;
import com.h2s.carpark.dto.request.TripRequest;
import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.dto.response.EmployeeResponse;
import com.h2s.carpark.dto.response.TripResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TripService {
    List<TripResponse> getAll();
    public TripResponse addTrip(TripRequest tripRequest);

    ApiResponse updateTrip(String id, TripRequest tripRequest);

    ApiResponse deleteTrip(String id);
}
