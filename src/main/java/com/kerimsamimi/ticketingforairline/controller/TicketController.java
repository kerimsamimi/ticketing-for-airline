package com.kerimsamimi.ticketingforairline.controller;

import com.kerimsamimi.ticketingforairline.entity.Payment;
import com.kerimsamimi.ticketingforairline.entity.Ticket;
import com.kerimsamimi.ticketingforairline.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    final static Logger logger = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private TicketService ticketService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody Ticket ticket){
        try {
            logger.info("[TICKET][CONTROLLER][ADD]");
            return ResponseEntity.ok(ticketService.createTicket(ticket));
        } catch (Exception e) {
            logger.error("[TICKET][CONTROLLER][ADD][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{ticketId}")
    public ResponseEntity getCompany(@PathVariable Long ticketId) {
        try {
            logger.info("[TICKET][CONTROLLER][GET]");
            return ResponseEntity.ok(ticketService.getTicket(ticketId));
        } catch (Exception e) {
            logger.error("[TICKET][CONTROLLER][GET][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "/sell-ticket/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sellTicket(@RequestBody Payment payment, @PathVariable Long ticketId){
        try {
            logger.info("[TICKET][CONTROLLER][PAYMENT]");
            return ResponseEntity.ok(ticketService.sellTicket(payment, ticketId));
        } catch (Exception e) {
            logger.error("[TICKET][CONTROLLER][PAYMENT][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/cancel-ticket/{ticketId}")
    public ResponseEntity cancelTicket(@PathVariable Long ticketId) {
        try {
            logger.info("[TICKET][CONTROLLER][CANCEL][TICKET]");
            return ResponseEntity.ok(ticketService.cancelTicket(ticketId));
        } catch (Exception e) {
            logger.error("[TICKET][CONTROLLER][CANCEL][TICKET][EXCEPTION]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
