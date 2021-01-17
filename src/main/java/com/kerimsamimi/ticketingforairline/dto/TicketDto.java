package com.kerimsamimi.ticketingforairline.dto;


public class TicketDto {
    private Long ticketId;
    private Integer price;
    private AirportDto airport;
    private FlightDto flight;
    private Boolean isSold;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public AirportDto getAirport() {
        return airport;
    }

    public void setAirport(AirportDto airport) {
        this.airport = airport;
    }

    public FlightDto getFlight() {
        return flight;
    }

    public void setFlight(FlightDto flight) {
        this.flight = flight;
    }

    public Boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(Boolean isSold) {
        this.isSold = isSold;
    }
}
