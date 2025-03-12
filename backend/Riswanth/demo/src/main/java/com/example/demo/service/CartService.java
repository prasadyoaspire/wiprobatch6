package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cart;
// import com.example.demo.entity.CartItems;

public interface CartService {
    Cart addMobileToCart(int cartId, int mobileId, int qty);

    // Cart removeMobileFromCart(int cartId,int mobileId);
    // Cart updateQtyInCart(int cartId,int mobileId,int qty);
    List<Cart> getAll();

    Cart getByCartId(int id);

    Cart updateCart(int cartItemId, int mobileId, int qty);

    Cart deleteCartItem(int cartItemId);

}
