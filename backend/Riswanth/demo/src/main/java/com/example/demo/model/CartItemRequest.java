package com.example.demo.model;

public class CartItemRequest {
    private int cartId;
    private int mobileId;
    private int qty;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public int getqty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
