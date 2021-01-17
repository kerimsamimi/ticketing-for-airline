package com.kerimsamimi.ticketingforairline.service;

import com.kerimsamimi.ticketingforairline.dto.CustomerDto;
import com.kerimsamimi.ticketingforairline.entity.Customer;

public interface CustomerService {
    CustomerDto createCustomer(Customer customer);
    CustomerDto getCustomerInfo(String email);
}
