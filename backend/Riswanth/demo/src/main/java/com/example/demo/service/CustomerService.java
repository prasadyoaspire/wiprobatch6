package com.example.demo.service;

import com.example.demo.entity.Customer;
// import com.example.demo.entity.Mobile;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);

    void deleteCustomer(int customerId);
}
