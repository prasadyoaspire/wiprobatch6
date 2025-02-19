package com.abc.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.customerservice.entity.Customer;
import com.abc.customerservice.exception.ResourceNotFoundException;
import com.abc.customerservice.repository.CustomerRepository;
//import com.abc.mobilestore.entity.Cart;
//import com.abc.mobilestore.repository.CartRepository;

@Service
public class CustomerServiceImpl implements CustomerService  {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//@Autowired
	//private CartRepository cartRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
			
		customer = customerRepository.save(customer);		

//		Cart cart= new Cart();
//		cart.setCartId(0); //auto-incremented
//		cart.setCartTotal(0);
//		cart.setCartItems(null);
//		cart.setCustomer(customer);	
//		
//		cartRepository.save(cart);
		
		return customer;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not found with id: "+customerId);
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
