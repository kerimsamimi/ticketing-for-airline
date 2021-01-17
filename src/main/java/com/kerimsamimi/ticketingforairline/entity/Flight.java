package com.kerimsamimi.ticketingforairline.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "FLIGHT")
public class Flight extends BaseEntity {

    @Id
    @Column(name = "FLIGHT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightId;

    @Column(name = "SOLIDITY_RATIO")
    private Integer solidityRatio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROUTE")
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY")
    private AirlineCompany airlineCompany;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public Integer getSolidityRatio() {
        return solidityRatio;
    }

    public void setSolidityRatio(Integer solidityRatio) {
        this.solidityRatio = solidityRatio;
    }
}
