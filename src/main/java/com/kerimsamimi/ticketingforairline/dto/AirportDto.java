package com.kerimsamimi.ticketingforairline.dto;

public class AirportDto extends BaseDto {
    String airportName;
    String airportCode;

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }
}
