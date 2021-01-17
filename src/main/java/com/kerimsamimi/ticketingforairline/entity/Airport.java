package com.kerimsamimi.ticketingforairline.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "AIRPORT")
public class Airport extends BaseEntity {

    @Id
    @Column(name = "AIRPORT_ID")
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2", parameters = { @org.hibernate.annotations.Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy") })
    private String id;

    @Column(name = "AIRPORT_NAME")
    private String airportName;

    @Column(name = "AIRPORT_CODE")
    private String airportCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
