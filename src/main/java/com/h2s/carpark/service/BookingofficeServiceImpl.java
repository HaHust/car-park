/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.response.BookingofficeResponse;
import com.h2s.carpark.entity.Bookingoffice;
import com.h2s.carpark.repository.BookingofficeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BookingofficeServiceImpl implements BookingofficeService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BookingofficeRepository bookingofficeRepository;

    @Override
    public List<BookingofficeResponse> getAll() {
        List<Bookingoffice> bookingoffices = bookingofficeRepository.findAll();
        List<BookingofficeResponse> bookingofficeResponses = new ArrayList<>();
        for (Bookingoffice it :
                bookingoffices) {
            bookingofficeResponses.add(mapper.map(it,BookingofficeResponse.class));
        }
        return bookingofficeResponses;
    }
}
