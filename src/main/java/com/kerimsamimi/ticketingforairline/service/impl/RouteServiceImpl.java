package com.kerimsamimi.ticketingforairline.service.impl;

import com.kerimsamimi.ticketingforairline.dto.RouteDto;
import com.kerimsamimi.ticketingforairline.entity.Route;
import com.kerimsamimi.ticketingforairline.repo.RouteRepository;
import com.kerimsamimi.ticketingforairline.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public RouteDto createRoute(Route route) {
        return modelMapper.map(routeRepository.save(route), RouteDto.class);
    }

    @Override
    public Route findByRouteCode(String routeCode){
        return routeRepository.findByRouteCode(routeCode);
    }
}
