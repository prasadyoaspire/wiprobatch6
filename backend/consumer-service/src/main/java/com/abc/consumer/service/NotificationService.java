package com.abc.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.abc.consumer.model.Order;

@Service
public class NotificationService {

	@KafkaListener(topics = "order-topic", groupId = "order-id")
	public void sendNotification(Order order) {
		
		System.out.println("Hello "+order.getCustomerName()+" Your Order is placed. Order Amount : "+order.getOrderAmount());;
	}
}
