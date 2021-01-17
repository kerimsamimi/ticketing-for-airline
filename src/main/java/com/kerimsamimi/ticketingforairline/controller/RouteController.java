package com.kerimsamimi.ticketingforairline.controller;

import com.kerimsamimi.ticketingforairline.entity.Route;
import com.kerimsamimi.ticketingforairline.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/route")
public class RouteController {
    final static Logger logger = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    private RouteService routeService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody Route route){
        try {
            logger.info("[ROUTE][CONTROLLER][ADD]");
            return ResponseEntity.ok(routeService.createRoute(route));
        } catch (Exception e) {
            logger.error("[ROUTE][CONTROLLER][ADD][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{routeCode}")
    public ResponseEntity getCompany(@PathVariable String routeCode) {
        try {
            logger.info("[ROUTE][CONTROLLER][GET]");
            return ResponseEntity.ok(routeService.findByRouteCode(routeCode));
        } catch (Exception e) {
            logger.error("[ROUTE][CONTROLLER][GET][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
