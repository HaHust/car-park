/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.BookingofficeRequest;
import com.h2s.carpark.dto.request.CarRequest;
import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.dto.response.CarResponse;
import com.h2s.carpark.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {
    List<CarResponse> getAll();

    public CarResponse addCar(CarRequest carRequest);

    ApiResponse updateCar(CarRequest carRequest);

    ApiResponse deleteCar(String licensePlate);
}
