package com.kerimsamimi.ticketingforairline.repo;

import com.kerimsamimi.ticketingforairline.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
    Airport findByAirportName(String airportName);
    Airport findByAirportCode(String airportCode);

}
