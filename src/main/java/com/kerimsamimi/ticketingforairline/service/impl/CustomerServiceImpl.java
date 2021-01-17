package com.kerimsamimi.ticketingforairline.service.impl;

import com.kerimsamimi.ticketingforairline.dto.CustomerDto;
import com.kerimsamimi.ticketingforairline.entity.Customer;
import com.kerimsamimi.ticketingforairline.repo.CustomerRepository;
import com.kerimsamimi.ticketingforairline.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(Customer customer) {
        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerInfo(String email) {
        return modelMapper.map(customerRepository.findByEmail(email), CustomerDto.class);
    }
}
