package com.kerimsamimi.ticketingforairline.repo;

import com.kerimsamimi.ticketingforairline.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
