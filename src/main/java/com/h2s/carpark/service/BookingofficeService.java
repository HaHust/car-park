/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.BookingofficeRequest;
import com.h2s.carpark.dto.request.EmployeeRequest;
import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.dto.response.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface BookingofficeService {
    List<BookingofficeResponse> getAll();

    public BookingofficeResponse addBookingoffice(BookingofficeRequest bookingofficeRequest);

    ApiResponse updateBookingoffice(String id, BookingofficeRequest bookingofficeRequest);

    ApiResponse deleteEmployee(String id);
}
