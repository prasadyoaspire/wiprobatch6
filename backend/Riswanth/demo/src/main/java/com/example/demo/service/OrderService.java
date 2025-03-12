package com.example.demo.service;

import java.util.List;

// import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;

public interface OrderService {
    Order placeOrder(int customer_id);

    Order getOrderDetails(int orderId);

    List<Order> getAllOrders();

    void deleteOrder(int orderId);
}
