/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.ParkinglotRequest;
import com.h2s.carpark.dto.request.TripRequest;
import com.h2s.carpark.dto.response.ParkinglotResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ParkinglotService {
    List<ParkinglotResponse> getAll();

    public ParkinglotResponse addParkinglot(ParkinglotRequest parkinglotRequest);

    ApiResponse updateParkinglot(Long id, ParkinglotRequest parkinglotRequest);

    ApiResponse deleteParkinglot(Long id);
}
