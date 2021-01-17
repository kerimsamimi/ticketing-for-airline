package com.kerimsamimi.ticketingforairline.service;

import com.kerimsamimi.ticketingforairline.dto.AirportDto;
import com.kerimsamimi.ticketingforairline.entity.Airport;

public interface AirportService {
    AirportDto createAirport(Airport airport);
    AirportDto getAirport(String airportName);
}
