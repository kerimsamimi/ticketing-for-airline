package com.kerimsamimi.ticketingforairline.repo;

import com.kerimsamimi.ticketingforairline.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {
}
