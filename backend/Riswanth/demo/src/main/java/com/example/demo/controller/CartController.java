package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItems;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.CartService;
import com.example.demo.model.CartItemRequest;

@CrossOrigin(origins = "http://localhost:3000/")

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/addItems")
    public ResponseEntity<Cart> addToCart(@RequestBody CartItemRequest cartItemRequest) {
        Cart cart = cartService.addMobileToCart(cartItemRequest.getCartId(), cartItemRequest.getMobileId(),
                cartItemRequest.getqty());
        return new ResponseEntity<>(cart, HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public List<Cart> fetchAll() {
        List<Cart> cart = cartService.getAll();
        return cart;
    }

    @GetMapping("/{cartId}")
    public Cart fetchById(@PathVariable int cartId) {
        Cart cart = cartService.getByCartId(cartId);
        return cart;

    }
    // @PutMapping("/update")
    // public ResponseEntity<Mobile> editMobile(@RequestBody Mobile mobile) {

    // mobileService.updateMobile(mobile);
    // ResponseEntity<Mobile> responseEntity = new ResponseEntity<>(mobile,
    // HttpStatus.OK);
    // return responseEntity;
    // }
    @PutMapping("/update")
    public ResponseEntity<Cart> updateCart(@RequestBody CartItems cartItems) {
        // Step 1: Validate input (Optional but recommended)
        if (cartItems.getQty() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        // Step 2: Call the service layer and get updated Cart
        Cart updatedCart = cartService.updateCart(
                cartItems.getCartitemsId(),
                cartItems.getMobileId(),
                cartItems.getQty());

        // Step 3: Return the updated cart
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<?> deleteCartItem(@PathVariable int cartItemId) {
        try {
            Cart updatedCart = cartService.deleteCartItem(cartItemId);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
