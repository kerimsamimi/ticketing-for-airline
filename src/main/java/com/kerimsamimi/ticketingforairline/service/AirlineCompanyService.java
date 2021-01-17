package com.kerimsamimi.ticketingforairline.service;

import com.kerimsamimi.ticketingforairline.dto.AirlineCompanyDto;
import com.kerimsamimi.ticketingforairline.entity.AirlineCompany;

public interface AirlineCompanyService {
    AirlineCompanyDto createCompany(AirlineCompany airlineCompany);
    AirlineCompanyDto getCompany(String companyName);
    AirlineCompany getCompanyByCompanyCode(String companyCode);
}
