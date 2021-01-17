package com.kerimsamimi.ticketingforairline.service;

import com.kerimsamimi.ticketingforairline.dto.PaymentDto;
import com.kerimsamimi.ticketingforairline.dto.TicketDto;
import com.kerimsamimi.ticketingforairline.entity.Payment;
import com.kerimsamimi.ticketingforairline.entity.Ticket;
import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

public interface TicketService {
    TicketDto createTicket(Ticket ticket);
    TicketDto getTicket(Long ticketId);
    PaymentDto sellTicket(Payment payment, Long ticketId) throws WrongNumberArgsException;
    TicketDto cancelTicket(Long ticketId);
}
