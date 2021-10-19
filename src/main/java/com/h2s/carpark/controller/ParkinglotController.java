/*
 * @created 05/10/2021 - 12:48 AM
 * @author vanha
 */

package com.h2s.carpark.controller;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.ParkinglotRequest;
import com.h2s.carpark.dto.request.TripRequest;
import com.h2s.carpark.dto.response.ParkinglotResponse;
import com.h2s.carpark.dto.response.TripResponse;
import com.h2s.carpark.service.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/parkinglot")
public class ParkinglotController {

    @Autowired
    private ParkinglotService parkinglotService;

    @GetMapping("")
    public List<ParkinglotResponse> getAll(){
        return parkinglotService.getAll();
    }

    @PostMapping("")
    public ParkinglotResponse addParkinglot(@RequestBody ParkinglotRequest parkinglotRequest){
        return parkinglotService.addParkinglot(parkinglotRequest);
    }

    @PutMapping("{id}")
    public ApiResponse updateParkinglot(@PathVariable("id") String id, @RequestBody ParkinglotRequest parkinglotRequest){
        return parkinglotService.updateParkinglot(id, parkinglotRequest);
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteParkinglot(@PathVariable("id") String id){
        return parkinglotService.deleteParkinglot(id);
    }

}
