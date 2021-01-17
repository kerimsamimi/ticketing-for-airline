package com.kerimsamimi.ticketingforairline.repo;

import com.kerimsamimi.ticketingforairline.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
