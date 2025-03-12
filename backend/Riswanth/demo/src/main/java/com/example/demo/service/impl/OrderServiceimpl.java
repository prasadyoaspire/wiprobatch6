package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItems;
// import com.example.demo.repository.OrderItemsRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;
import com.example.demo.repository.CartItemsRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CartItems;
import java.util.List;
import java.util.Optional;
// import java.time.LocalDate;
import java.time.LocalDate;
// import java.util.List;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.ArrayList;

@Service
public class OrderServiceimpl implements OrderService {
  @Autowired
  private OrderRepository orderRepository;
  // @Autowired
  // private OrderItemsRepository orderItemRepository;
  @Autowired
  private CustomerService customerService;
  @Autowired
  private CartItemsRepository cartItemRepository;
  @Autowired
  private CartRepository cartRepository;

  @Override
  public Order placeOrder(int customerId) {
    Customer customer = customerService.getCustomerById(customerId);
    Cart cart = customer.getCart();
    List<CartItems> cartItem = cart.getCartItems();
    Order order = new Order();
    order.setOrderAmount(cart.getCartTotal());
    System.out.println(order.getOrderAmount());
    order.setOrderStatus("Pending");
    order.setOrderDate(LocalDate.now());
    order.setCustomer(customer);
    List<OrderItems> orderitems = new ArrayList<>();
    for (CartItems item : cartItem) {

      OrderItems orderItem = new OrderItems();
      orderItem.setItemTotal(item.getItemTotal());
      orderItem.setMobileId(item.getMobileId());
      orderItem.setQty(item.getQty());
      orderItem.setOrder(order);
      orderitems.add(orderItem);

    }

    order.setOrderitems(orderitems);
    orderRepository.save(order);
    // clear carttable
    for (CartItems item : cartItem) {

      cartItemRepository.delete(item);

    }
    // cartRepository.deleteAll(cartItems);
    cart.setCartItems(null);
    cart.setCartTotal(0);
    cartRepository.save(cart);

    return order;
  }

  @Override
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  @Override
  public Order getOrderDetails(int orderId) {
    Optional<Order> optionalOrder = orderRepository.findById(orderId);
    if (optionalOrder.isEmpty()) {
      throw new ResourceNotFoundException("Order not found with id:" + orderId);

    }
    Order order = optionalOrder.get();
    return order;
  }

  @Override
  public void deleteOrder(int orderId) {
    // ✅ Step 1: Find the order by orderId
    Optional<Order> optionalOrder = orderRepository.findById(orderId);

    // ✅ Step 2: Check if the order exists
    if (optionalOrder.isEmpty()) {
      throw new ResourceNotFoundException("Order not found with ID: " + orderId);
    }

    // ✅ Step 3: Delete the order (and cascade will delete orderItems too)
    Order order = optionalOrder.get();
    orderRepository.delete(order);
  }

}
