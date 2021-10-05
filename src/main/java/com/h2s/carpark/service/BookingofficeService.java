/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.response.BookingofficeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingofficeService {
    List<BookingofficeResponse> getAll();
}
