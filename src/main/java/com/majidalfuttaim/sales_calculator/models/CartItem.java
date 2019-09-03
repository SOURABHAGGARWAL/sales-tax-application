package com.majidalfuttaim.sales_calculator.models;

import java.io.Serializable;

/**
 * Class used to hold the cart item data.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class CartItem implements Serializable{
    private static final long serialVersionUID = 8902463214424924777L;
    
    private Product product;
    private int quantity;
    private Double tax;
    private Double cost;
    
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getCost() {
        return quantity * (tax + product.getPrice());
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
