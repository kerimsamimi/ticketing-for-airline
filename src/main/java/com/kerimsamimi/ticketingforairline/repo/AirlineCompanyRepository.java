package com.kerimsamimi.ticketingforairline.repo;

import com.kerimsamimi.ticketingforairline.entity.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, String> {
    AirlineCompany findByCompanyName(String companyName);
    AirlineCompany findByCompanyCode(String companyCode);
}
