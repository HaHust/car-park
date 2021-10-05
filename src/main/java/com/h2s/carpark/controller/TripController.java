/*
 * @created 05/10/2021 - 12:48 AM
 * @author vanha
 */

package com.h2s.carpark.controller;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.BookingofficeRequest;
import com.h2s.carpark.dto.request.EmployeeRequest;
import com.h2s.carpark.dto.request.TripRequest;
import com.h2s.carpark.dto.response.EmployeeResponse;
import com.h2s.carpark.dto.response.TripResponse;
import com.h2s.carpark.service.EmployeeService;
import com.h2s.carpark.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping("")
    public List<TripResponse> getAll(){
        return tripService.getAll();
    }

    @PostMapping("")
    public TripResponse addTrip(@RequestBody TripRequest tripRequest){
        return tripService.addTrip(tripRequest);
    }

    @PutMapping("{id}")
    public ApiResponse updateTrip(@PathVariable("id") Long id, @RequestBody TripRequest tripRequest){
        return tripService.updateTrip(id, tripRequest);
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteTrip(@PathVariable("id") Long id){
        return tripService.deleteTrip(id);
    }
}
