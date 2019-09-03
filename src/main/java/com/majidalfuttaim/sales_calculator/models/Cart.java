package com.majidalfuttaim.sales_calculator.models;

import java.io.Serializable;
import java.util.List;

/**
 * Class used to hold the cart data.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = 6541749959830467206L;

    private List<CartItem> cartItems;
    private Double totalTax;
    private Double totalCost;

    public Cart(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Double getTotalTax() {
        return cartItems.stream().mapToDouble(item -> item.getTax()).sum();
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public Double getTotalCost() {
        return cartItems.stream().mapToDouble(item -> item.getCost()).sum();
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
        result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
        result = prime * result + ((totalTax == null) ? 0 : totalTax.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (cartItems == null) {
            if (other.cartItems != null)
                return false;
        } else if (!cartItems.equals(other.cartItems))
            return false;
        if (totalCost == null) {
            if (other.totalCost != null)
                return false;
        } else if (!totalCost.equals(other.totalCost))
            return false;
        if (totalTax == null) {
            if (other.totalTax != null)
                return false;
        } else if (!totalTax.equals(other.totalTax))
            return false;
        return true;
    }

}
