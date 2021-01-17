package com.kerimsamimi.ticketingforairline.service.impl;

import com.kerimsamimi.ticketingforairline.dto.AirlineCompanyDto;
import com.kerimsamimi.ticketingforairline.entity.AirlineCompany;
import com.kerimsamimi.ticketingforairline.repo.AirlineCompanyRepository;
import com.kerimsamimi.ticketingforairline.service.AirlineCompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    @Autowired
    private AirlineCompanyRepository airlineCompanyRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AirlineCompanyDto createCompany(AirlineCompany airlineCompany) {

        AirlineCompany company = airlineCompanyRepository.save(airlineCompany);
        return modelMapper.map(company, AirlineCompanyDto.class);

    }

    @Override
    public AirlineCompanyDto getCompany(String companyName) {
        AirlineCompany company = airlineCompanyRepository.findByCompanyName(companyName);

        return modelMapper.map(company, AirlineCompanyDto.class);
    }

    @Override
    public AirlineCompany getCompanyByCompanyCode(String companyCode) {

        return airlineCompanyRepository.findByCompanyCode(companyCode);
    }
}
