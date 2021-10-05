/*
 * @created 05/10/2021 - 12:47 AM
 * @author vanha
 */

package com.h2s.carpark.controller;

import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.dto.response.EmployeeResponse;
import com.h2s.carpark.service.BookingofficeService;
import com.h2s.carpark.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/bookingoffice")
public class BookingofficeController {

    @Autowired
    private BookingofficeService bookingofficeService;

    @GetMapping("")
    public List<BookingofficeResponse> getAll(){
        return bookingofficeService.getAll();
    }
}
