package com.abc.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.orderservice.entity.Order;
import com.abc.orderservice.entity.OrderItem;
import com.abc.orderservice.model.InvoiceDTO;
import com.abc.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/create/{customerId}")
	public ResponseEntity<Order> createOrder(@PathVariable int customerId,@RequestBody List<OrderItem> orderItems) {
		
		Order order = orderService.placeOrder(customerId, orderItems);
		
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId) {
		
		Order order = orderService.getOrderDetails(orderId);
		
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@GetMapping("/invoice")
	public ResponseEntity<InvoiceDTO> createInvoice(@RequestParam("orderId") int orderId) {
		
		InvoiceDTO invoiceDto = orderService.generateInvoice(orderId);		
		
		return new ResponseEntity<>(invoiceDto,HttpStatus.OK);
	}
}
