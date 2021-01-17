package com.kerimsamimi.ticketingforairline.service.impl;

import com.kerimsamimi.ticketingforairline.dto.AirlineCompanyDto;
import com.kerimsamimi.ticketingforairline.dto.FlightDto;
import com.kerimsamimi.ticketingforairline.entity.AirlineCompany;
import com.kerimsamimi.ticketingforairline.entity.Flight;
import com.kerimsamimi.ticketingforairline.repo.FlightRepository;
import com.kerimsamimi.ticketingforairline.repo.RouteRepository;
import com.kerimsamimi.ticketingforairline.service.AirlineCompanyService;
import com.kerimsamimi.ticketingforairline.service.FlightService;
import com.kerimsamimi.ticketingforairline.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlineCompanyService airlineCompanyService;

    @Autowired
    private RouteService routeService;

    @Override
    public FlightDto createFlight(Flight flight) {
        flight.setRoute(routeService.findByRouteCode(flight.getRoute().getRouteCode()));
        flight.setAirlineCompany(airlineCompanyService.getCompanyByCompanyCode(flight.getAirlineCompany().getCompanyCode()));
        return modelMapper.map(flightRepository.save(flight), FlightDto.class);
    }

    @Override
    public FlightDto getFlight(Long flightId) {
        Flight flight = flightRepository.getOne(flightId);

        return modelMapper.map(flight, FlightDto.class);
    }
}
