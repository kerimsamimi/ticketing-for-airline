package com.kerimsamimi.ticketingforairline.dto;

public class FlightDto extends BaseDto {
    private Long flightId;
    private Integer solidityRatio;
    private RouteDto route;
    private AirlineCompanyDto airlineCompany;

    public Integer getSolidityRatio() {
        return solidityRatio;
    }

    public void setSolidityRatio(Integer solidityRatio) {
        this.solidityRatio = solidityRatio;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public RouteDto getRoute() {
        return route;
    }

    public void setRoute(RouteDto route) {
        this.route = route;
    }

    public AirlineCompanyDto getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompanyDto airlineCompany) {
        this.airlineCompany = airlineCompany;
    }
}
