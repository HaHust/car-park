/*
 * @created 05/10/2021 - 12:47 AM
 * @author vanha
 */

package com.h2s.carpark.controller;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.BookingofficeRequest;
import com.h2s.carpark.dto.request.EmployeeRequest;
import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.dto.response.EmployeeResponse;
import com.h2s.carpark.service.BookingofficeService;
import com.h2s.carpark.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/bookingoffice")
public class BookingofficeController {

    @Autowired
    private BookingofficeService bookingofficeService;

    @GetMapping("")
    public List<BookingofficeResponse> getAll(){
        return bookingofficeService.getAll();
    }

    @PostMapping("")
    public BookingofficeResponse addBookingoffice(@RequestBody BookingofficeRequest bookingofficeRequest){
        return bookingofficeService.addBookingoffice(bookingofficeRequest);
    }

    @PutMapping("{id}")
    public ApiResponse updateBookingoffice(@PathVariable("id") String id, @RequestBody BookingofficeRequest bookingofficeRequest){
        return bookingofficeService.updateBookingoffice(id, bookingofficeRequest);
    }

    @DeleteMapping("{id}")
    public ApiResponse deletebookingoffice(@PathVariable("id") String id){
        return bookingofficeService.deleteEmployee(id);
    }
}
