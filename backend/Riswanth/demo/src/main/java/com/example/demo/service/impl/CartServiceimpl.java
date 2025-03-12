package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
// import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.CartItemsRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.MobileService;
import com.example.demo.entity.Cart;
// import com.example.demo.entity.Customer;
import com.example.demo.entity.CartItems;
import com.example.demo.entity.Mobile;
import java.util.List;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class CartServiceimpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    // @Override
    // public Customer saveCustomer(Customer customer)
    // {
    // customer=CustomerRepository.save(customer);
    // Cart cart=new Cart();
    // cart.setCartTotal(0);
    // cart.setCustomer(customer);
    // cartRepository.save(cart);
    // return customer;
    // }
    @Autowired
    private CartItemsRepository cartItemRepository;
    @Autowired
    private MobileService mobileService;

    @Override
    public Cart addMobileToCart(int cartId, int mobileId, int qty) {
        System.out.println("Received Quantity: " + qty);

        Mobile mobile = mobileService.getMobileById(mobileId);
        double price = mobile.getPrice();
        // System.out.println(price);
        double itemTotal = qty * price;
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isEmpty()) {
            throw new ResourceNotFoundException("Cart not found with id:" + cartId);
        }
        Cart cart = optionalCart.get();

        CartItems cartItem = new CartItems();
        cartItem.setMobileId(mobileId);
        cartItem.setQty(qty);
        cartItem.setItemTotal(itemTotal);
        cartItem.setCart(cart);
        cartItemRepository.save(cartItem);
        // update cart total
        double cartTotal = 0;
        List<CartItems> cartItems = cart.getCartItems();
        for (CartItems item : cartItems) {
            double total = item.getItemTotal();
            cartTotal = cartTotal + total;

        }
        cart.setCartTotal(cartTotal);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public List<Cart> getAll() {
        // TODO Auto-generated method stub
        List<Cart> cart = cartRepository.findAll();
        return cart;
    }

    @Override
    public Cart getByCartId(int id) {
        // TODO Auto-generated method stub
        Optional<Cart> optionalCart = cartRepository.findById(id);
        return optionalCart.get();
    }

    @Override
    public Cart updateCart(int cartItemId, int mobileId, int qty) {

        System.out.println("Received Quantity: " + qty);

        // Step 1: Fetch Mobile from DB
        Mobile mobile = mobileService.getMobileById(mobileId);
        double price = mobile.getPrice();
        double itemTotal = qty * price;

        // Step 2: Fetch CartItem from DB
        Optional<CartItems> optionalCartItem = cartItemRepository.findById(cartItemId);
        CartItems cartItem = optionalCartItem
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found with id: " + cartItemId));

        // Step 3: Fetch Cart from CartItem (No need for Optional<Cart>)
        Cart cart = cartItem.getCart();
        if (cart == null) {
            throw new ResourceNotFoundException("Cart not found for CartItem ID: " + cartItemId);
        }

        // Step 4: Update CartItem with new values
        cartItem.setMobileId(mobileId);
        cartItem.setQty(qty);
        cartItem.setItemTotal(itemTotal);

        // Step 5: Save the updated CartItem
        cartItemRepository.save(cartItem);

        // Step 6: Update the total cart value dynamically
        double cartTotal = 0;
        for (CartItems item : cart.getCartItems()) {
            cartTotal += item.getItemTotal();
        }
        cart.setCartTotal(cartTotal);

        // Step 7: Save the updated Cart
        cartRepository.save(cart);

        System.out.println("Cart updated successfully. New Total: " + cartTotal);

        // Step 8: Return updated cart
        return cart;
    }

    @Override
    public Cart deleteCartItem(int cartItemId) {
        Optional<CartItems> optionalCartItem = cartItemRepository.findById(cartItemId);

        if (optionalCartItem.isEmpty()) {
            throw new ResourceNotFoundException("Cart Item not found with ID: " + cartItemId);
        }

        // Fetch the cartItem and its associated cart
        CartItems cartItem = optionalCartItem.get();
        Cart cart = cartItem.getCart();

        // Remove the cart item from the cart
        cart.getCartItems().remove(cartItem);

        // Delete the cart item from the database
        cartItemRepository.delete(cartItem);

        // Update the cart total
        double cartTotal = 0;
        for (CartItems item : cart.getCartItems()) {
            cartTotal += item.getItemTotal();
        }
        cart.setCartTotal(cartTotal);

        // Save the updated cart
        cartRepository.save(cart);

        return cart;
    }

}
