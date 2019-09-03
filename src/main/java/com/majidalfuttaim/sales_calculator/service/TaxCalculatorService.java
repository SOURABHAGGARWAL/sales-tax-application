package com.majidalfuttaim.sales_calculator.service;

import com.majidalfuttaim.sales_calculator.models.CartItem;

/**
 * Interface for the tax caculator service.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public interface TaxCalculatorService {

    /**
     * Method used to calculate the cart item tax.
     * 
     * @param cartItem
     */
    public void calculateItemTax(CartItem cartItem);

    /**
     * Method used to calculate the cost of the item in the cart
     * 
     * @param cart
     */
    public void calculateItemCost(CartItem cartItem);

}
