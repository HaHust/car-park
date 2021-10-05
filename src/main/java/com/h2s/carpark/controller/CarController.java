/*
 * @created 05/10/2021 - 12:47 AM
 * @author vanha
 */

package com.h2s.carpark.controller;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.BookingofficeRequest;
import com.h2s.carpark.dto.request.CarRequest;
import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.dto.response.CarResponse;
import com.h2s.carpark.repository.CarRepository;
import com.h2s.carpark.service.BookingofficeService;
import com.h2s.carpark.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("")
    public List<CarResponse> getAll(){
        return carService.getAll();
    }

    @PostMapping("")
    public CarResponse addCar(@RequestBody CarRequest carRequest){
        return carService.addCar(carRequest);
    }

    @PutMapping("")
    public ApiResponse updateCar(@RequestBody CarRequest carRequest){
        return carService.updateCar(carRequest);
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteCar(@PathVariable("id") String id){
        return carService.deleteCar(id);
    }
}
