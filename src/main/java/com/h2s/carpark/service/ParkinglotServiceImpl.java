/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.ParkinglotRequest;
import com.h2s.carpark.dto.response.ParkinglotResponse;
import com.h2s.carpark.dto.response.TripResponse;
import com.h2s.carpark.entity.Parkinglot;
import com.h2s.carpark.entity.Trip;
import com.h2s.carpark.repository.ParkinglotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkinglotServiceImpl implements ParkinglotService{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ParkinglotRepository parkinglotRepository;

    @Override
    public List<ParkinglotResponse> getAll() {
        List<Parkinglot> parkinglots = parkinglotRepository.findAll();
        List<ParkinglotResponse> parkinglotResponses = new ArrayList<>();
        for (Parkinglot it : parkinglots) {
            parkinglotResponses.add(mapper.map(it,ParkinglotResponse.class));
        }
        return parkinglotResponses;
    }

    @Override
    public ParkinglotResponse addParkinglot(ParkinglotRequest parkinglotRequest) {
        Parkinglot parkinglot = mapper.map(parkinglotRequest,Parkinglot.class);
        Parkinglot parkinglot1 = parkinglotRepository.save(parkinglot);
        ParkinglotResponse parkinglotResponse = mapper.map(parkinglot1, ParkinglotResponse.class);
        return parkinglotResponse;
    }

    @Override
    public ApiResponse updateParkinglot(String id, ParkinglotRequest parkinglotRequest) {
        Optional<Parkinglot> parkinglot = parkinglotRepository.findById(id);
        if(!parkinglot.isPresent())
            return new ApiResponse(false, "Employee can't find");
        Parkinglot result = mapper.map(parkinglotRequest,Parkinglot.class);
        result.setParkId(parkinglot.get().getParkId());
        try {
            Parkinglot parkinglotSave = parkinglotRepository.save(result);
            return new ApiResponse(true,mapper.map(parkinglotSave,TripResponse.class).toString());
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }

    @Override
    public ApiResponse deleteParkinglot(String id) {
        try {
            parkinglotRepository.deleteById(id);
            return new ApiResponse(true,"delete parkinglot Success");
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }
}
