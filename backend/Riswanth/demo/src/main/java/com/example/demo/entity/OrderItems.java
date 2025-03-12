package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orderitems_tbl")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItems_Id;
    private int mobileId;
    private int qty;
    private double itemTotal;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    

    public int getOrderItems_Id() {
        return orderItems_Id;
    }

    public void setOrderItems_Id(int orderItems_Id) {
        this.orderItems_Id = orderItems_Id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getOrderId() {
        return orderItems_Id;
    }

    public void setOrderId(int orderId) {
        this.orderItems_Id = orderId;
    }

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

}
