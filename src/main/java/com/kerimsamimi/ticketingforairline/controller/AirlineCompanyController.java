package com.kerimsamimi.ticketingforairline.controller;

import com.kerimsamimi.ticketingforairline.entity.AirlineCompany;
import com.kerimsamimi.ticketingforairline.service.AirlineCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class AirlineCompanyController {

    @Autowired
    private AirlineCompanyService airlineCompanyService;

    final static Logger logger = LoggerFactory.getLogger(AirlineCompanyController.class);

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody AirlineCompany airlineCompany) {
        try {
            logger.info("[AIRLINE][COMPANY][CONTROLLER][ADD]");
            return ResponseEntity.ok(airlineCompanyService.createCompany(airlineCompany));
        } catch (Exception e) {
            logger.error("[AIRLINE][COMPANY][CONTROLLER][ADD][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping(value = "/{companyName}")
    public ResponseEntity getCompany(@PathVariable String companyName) {
        try {
            logger.info("[AIRLINE][COMPANY][CONTROLLER][GET]");
            return ResponseEntity.ok(airlineCompanyService.getCompany(companyName));
        } catch (Exception e) {
            logger.error("[AIRLINE][COMPANY][CONTROLLER][GET][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
