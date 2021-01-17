package com.kerimsamimi.ticketingforairline.service;

import com.kerimsamimi.ticketingforairline.dto.RouteDto;
import com.kerimsamimi.ticketingforairline.entity.Route;

public interface RouteService {
    RouteDto createRoute(Route route);
    Route findByRouteCode(String routeCode);
}
