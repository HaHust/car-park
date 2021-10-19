/*
 * @created 05/10/2021 - 12:41 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.CarRequest;
import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.dto.response.CarResponse;
import com.h2s.carpark.entity.Bookingoffice;
import com.h2s.carpark.entity.Car;
import com.h2s.carpark.entity.Parkinglot;
import com.h2s.carpark.entity.Trip;
import com.h2s.carpark.repository.CarRepository;
import com.h2s.carpark.repository.ParkinglotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ParkinglotRepository parkinglotRepository;

    @Override
    public List<CarResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<CarResponse> carResponses = new ArrayList<>();
        for (Car it : cars) {
            carResponses.add(mapper.map(it,CarResponse.class));
        }
        return carResponses;
    }

    @Override
    public CarResponse addCar(CarRequest carRequest) {
        String parkId = carRequest.getParkId();
        Optional<Parkinglot> parkinglot = parkinglotRepository.findById(parkId);
        if(!parkinglot.isPresent())
            return null;
        Car car = mapper.map(carRequest,Car.class);
        car.setParkinglot(parkinglot.get());
        Car car1 = carRepository.save(car);
        CarResponse carResponse = mapper.map(car1, CarResponse.class);
        return carResponse;
    }

    @Override
    public ApiResponse updateCar(CarRequest carRequest) {
        Optional<Car> car = carRepository.findCarByLicensePlate(carRequest.getLicensePlate());
        Optional<Parkinglot> parkinglot = parkinglotRepository.findById(carRequest.getParkId());

        if(!car.isPresent())
            return new ApiResponse(false, "Car can't find");
        Car result = mapper.map(carRequest,Car.class);

        result.setParkinglot(car.get().getParkinglot());
        try {
            Car car1 = carRepository.save(result);
            return new ApiResponse(true,car1.toString());
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }

    @Override
    public ApiResponse deleteCar(String licensePlate) {
        try {
            Optional<Car> car = carRepository.findCarByLicensePlate(licensePlate);
            carRepository.delete(car.get());
            return new ApiResponse(true,"delete employee Success");
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }
}
