package com.majidalfuttaim.sales_calculator;

import org.junit.Test;

import com.majidalfuttaim.sales_calculator.models.Cart;

import junit.framework.TestCase;

/**
 * Junit test case for the SalesTaxApplication.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class SalesTaxApplicationTest extends TestCase {

    @Test
    public void testInput1() {
        String[] input1 = { "1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85" };
        Cart cart = SalesTaxApplication.processInput(input1);
        assertEquals(29.830000000000005, cart.getTotalCost());
        assertEquals(1.5, cart.getTotalTax());
    }

    @Test
    public void testInput2() {
        String[] input2 = { "1 imported box of chocolates at 10.00", "1 imported bottle of perfume at 47.50" };
        Cart cart = SalesTaxApplication.processInput(input2);
        assertEquals(65.15, cart.getTotalCost());
        assertEquals(7.65, cart.getTotalTax());
    }

    @Test
    public void testInput3() {
        String[] input3 = { "1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99", "1 packet of headache pills at 9.75",
                "1 box of imported chocolates at 11.25" };
        Cart cart = SalesTaxApplication.processInput(input3);
        assertEquals(74.67999999999999, cart.getTotalCost());
        assertEquals(6.7, cart.getTotalTax());
    }
}
