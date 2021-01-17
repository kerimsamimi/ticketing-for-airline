package com.kerimsamimi.ticketingforairline.service.impl;

import com.kerimsamimi.ticketingforairline.dto.AirportDto;
import com.kerimsamimi.ticketingforairline.entity.Airport;
import com.kerimsamimi.ticketingforairline.repo.AirportRepository;
import com.kerimsamimi.ticketingforairline.service.AirportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AirportDto createAirport(Airport airport) {
        return modelMapper.map(airportRepository.save(airport), AirportDto.class);
    }

    @Override
    public AirportDto getAirport(String airportName) {
        Airport airport = airportRepository.findByAirportName(airportName);
        return modelMapper.map(airport, AirportDto.class);
    }
}
