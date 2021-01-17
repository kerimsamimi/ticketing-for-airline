package com.kerimsamimi.ticketingforairline.controller;

import com.kerimsamimi.ticketingforairline.entity.Customer;
import com.kerimsamimi.ticketingforairline.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody Customer customer){
        try {
            logger.info("[CUSTOMER][CONTROLLER][ADD]");
            return ResponseEntity.ok(customerService.createCustomer(customer));
        } catch (Exception e) {
            logger.error("[CUSTOMER][CONTROLLER][ADD][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
