package com.abc.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.orderservice.model.CustomerDTO;

@FeignClient(value="CUSTOMER-SERVICE")
public interface CustomerApiClient {

	@GetMapping("/customer/{customerId}")
	CustomerDTO getCustomerDetails(@PathVariable int customerId);
}
