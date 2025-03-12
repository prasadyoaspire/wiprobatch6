package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Customer;
// import com.example.demo.entity.Mobile;

import java.util.List;
import java.util.Optional;
import com.example.demo.repository.CartRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceimpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        customer = customerRepository.save(customer);
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        cartRepository.save(cart);
        return customer;
    }

    @Override
    public void deleteCustomer(int customerId) {
        // TODO Auto-generated method stub
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new ResourceNotFoundException("Customer not existing with id: " + customerId);
        }
        Customer customer = optionalCustomer.get();
        customerRepository.delete(customer);

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
        if (optionalCustomer.isEmpty()) {
            throw new ResourceNotFoundException("Customer not existing with id: " + customer.getCustomerId());
        }
        customerRepository.save(customer);
        return customer;

    }

    @Override
    public Customer getCustomerById(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new ResourceNotFoundException("Customer not found with id:" + customerId);

        }
        Customer customer = optionalCustomer.get();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }
}
