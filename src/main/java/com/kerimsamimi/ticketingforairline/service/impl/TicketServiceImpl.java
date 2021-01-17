package com.kerimsamimi.ticketingforairline.service.impl;

import com.kerimsamimi.ticketingforairline.dto.PaymentDto;
import com.kerimsamimi.ticketingforairline.dto.TicketDto;
import com.kerimsamimi.ticketingforairline.entity.Airport;
import com.kerimsamimi.ticketingforairline.entity.Payment;
import com.kerimsamimi.ticketingforairline.entity.Ticket;
import com.kerimsamimi.ticketingforairline.repo.*;
import com.kerimsamimi.ticketingforairline.service.FlightService;
import com.kerimsamimi.ticketingforairline.service.RouteService;
import com.kerimsamimi.ticketingforairline.service.TicketService;
import com.kerimsamimi.ticketingforairline.utils.GeneralEnums;
import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public TicketDto createTicket(Ticket ticket) {
        ticket.setAirport(airportRepository.findByAirportCode(ticket.getAirport().getAirportCode()));
        ticket.setFlight(flightRepository.getOne(ticket.getFlight().getFlightId()));
        if(!ticket.getFlight().getSolidityRatio().equals(GeneralEnums.ZERO)){
            Integer ticketPrice = ticket.getPrice();
            ticketPrice = ticketPrice + ((ticketPrice*ticket.getFlight().getSolidityRatio())/100);
            ticket.setPrice(ticketPrice);
        }
        return modelMapper.map(ticketRepository.save(ticket), TicketDto.class);
    }

    @Override
    public TicketDto getTicket(Long ticketId) {
        return modelMapper.map(ticketRepository.getOne(ticketId), TicketDto.class);
    }

    @Override
    @Transactional
    public PaymentDto sellTicket(Payment payment, Long ticketId) throws WrongNumberArgsException {
        payment.setCardNo(payment.getCardNo().replaceAll("[^0-9]", ""));
        Ticket ticket = ticketRepository.getOne(ticketId);
        ticket.setIsSold(true);
        payment.setTicket(ticket);
        payment.setCustomer(customerRepository.findByEmail(payment.getCustomer().getEmail()));
        PaymentDto paymentDto = modelMapper.map(paymentRepository.save(payment), PaymentDto.class);
        if(paymentDto.getCardNo().length() == GeneralEnums.CREDIT_CARD_TOTAL_DIGIT){
            String cardNo = paymentDto.getCardNo().substring(0,6) + "******" + paymentDto.getCardNo().substring(12,16);
            paymentDto.setCardNo(cardNo);
        }else{
            throw new WrongNumberArgsException(payment.getCardNo());
        }
        return paymentDto;
    }

    @Override
    public TicketDto cancelTicket(Long ticketId) {
        Ticket ticket = ticketRepository.getOne(ticketId);
        ticket.setIsSold(false);
        return modelMapper.map(ticket, TicketDto.class);
    }
}
