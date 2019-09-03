package com.majidalfuttaim.sales_calculator.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.majidalfuttaim.sales_calculator.factory.ObjectFactory;
import com.majidalfuttaim.sales_calculator.models.CartItem;
import com.majidalfuttaim.sales_calculator.models.Product;

/**
 * Junit test case for the TaxCalculatorServiceImpl.
 * 
 * @author sourabhaggarwal on 3-SEP-2019 `
 */
public class TaxCalculatorServiceImplTest {
    @Test
    public void testCalculateItemTax() {
        Product product = new Product("imported prefume", 5.67);
        CartItem cartItem = new CartItem(product, 2);
        ObjectFactory.getTaxCalculatorService().calculateItemTax(cartItem);
        System.out.println(cartItem.getTax().doubleValue());
        assertEquals(1.8000000000000003, cartItem.getTax().doubleValue(), 0.0);
    }

    @Test
    public void testCalculateItemCost() {
        Product product = new Product("imported prefume", 5.67);
        CartItem cartItem = new CartItem(product, 2);
        cartItem.setTax(1.8000000000000003);
        ObjectFactory.getTaxCalculatorService().calculateItemCost(cartItem);
        assertEquals(14.940000000000001, cartItem.getCost().doubleValue(), 0.0);
    }

}
