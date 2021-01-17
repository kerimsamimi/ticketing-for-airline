package com.kerimsamimi.ticketingforairline.controller;

import com.kerimsamimi.ticketingforairline.entity.Airport;
import com.kerimsamimi.ticketingforairline.service.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/airport")
public class AirportController {
    final static Logger logger = LoggerFactory.getLogger(AirportController.class);

    @Autowired
    private AirportService airportService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody Airport airport){
        try {
            logger.info("[AIRPORT][CONTROLLER][ADD]");
            return ResponseEntity.ok(airportService.createAirport(airport));
        } catch (Exception e) {
            logger.error("[AIRPORT][CONTROLLER][ADD][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{airportName}")
    public ResponseEntity getCompany(@PathVariable String airportName) {
        try {
            logger.info("[AIRPORT][CONTROLLER][GET]");
            return ResponseEntity.ok(airportService.getAirport(airportName));
        } catch (Exception e) {
            logger.error("[AIRPORT][CONTROLLER][GET][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
