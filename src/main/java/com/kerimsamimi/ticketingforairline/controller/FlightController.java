package com.kerimsamimi.ticketingforairline.controller;

import com.kerimsamimi.ticketingforairline.entity.Flight;
import com.kerimsamimi.ticketingforairline.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    final static Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private FlightService flightService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody Flight flight){
        try {
            logger.info("[FLIGHT][CONTROLLER][ADD]");
            return ResponseEntity.ok(flightService.createFlight(flight));
        } catch (Exception e) {
            logger.error("[FLIGHT][CONTROLLER][ADD][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{flightId}")
    public ResponseEntity getCompany(@PathVariable Long flightId) {
        try {
            logger.info("[AIRPORT][CONTROLLER][GET]");
            return ResponseEntity.ok(flightService.getFlight(flightId));
        } catch (Exception e) {
            logger.error("[AIRPORT][CONTROLLER][GET][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
