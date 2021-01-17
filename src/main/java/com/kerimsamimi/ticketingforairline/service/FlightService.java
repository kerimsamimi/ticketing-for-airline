package com.kerimsamimi.ticketingforairline.service;

import com.kerimsamimi.ticketingforairline.dto.FlightDto;
import com.kerimsamimi.ticketingforairline.entity.Flight;

public interface FlightService {
    FlightDto createFlight(Flight flight);
    FlightDto getFlight(Long flightId);
}
