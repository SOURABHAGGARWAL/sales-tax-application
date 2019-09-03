package com.majidalfuttaim.sales_calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.majidalfuttaim.sales_calculator.factory.ObjectFactory;
import com.majidalfuttaim.sales_calculator.models.Cart;
import com.majidalfuttaim.sales_calculator.service.TaxCalculatorService;
import com.majidalfuttaim.sales_calculator.utils.InputParser;

/**
 * Class will be used to start the application, can take the input as the command line.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class SalesTaxApplication {
    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private static TaxCalculatorService taxCalculatorService = ObjectFactory.getTaxCalculatorService();

    // Main of the application need if we want to execute the input with terminal
    public static void main(String[] args) {
        System.out.println("--------------------- START ENTERING INPUTS -------------------------");
        List<String> list = new ArrayList<String>();
        while (true) {
            list.add(ObjectFactory.getInputscanner().nextLine());
            System.out.println("WANTED TO ADD MORE PRODUCTS y/n : ");
            String moreProduct = ObjectFactory.getInputscanner().nextLine();
            if (moreProduct.equalsIgnoreCase("y")) {
                continue;
            } else if (moreProduct.equalsIgnoreCase("n")) {
                String[] array = new String[list.size()];
                processInput(list.toArray(array));
                list.clear();
            }
        }
    }

    // Method used to calculate and print the tax caculation of th given input string as array. 
    public static Cart processInput(String[] input) {
        System.out.println("------------------------- INPUT ------------------------");
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        Cart cart = InputParser.parseCart(input);
        System.out.println("---------------------- OUTPUT --------------------------");
        cart.getCartItems().forEach(cartItem -> {
            taxCalculatorService.calculateItemTax(cartItem);
            taxCalculatorService.calculateItemCost(cartItem);
            System.out.println(cartItem.getQuantity() + " " + cartItem.getProduct().getName() + ": " + decimalFormat.format(cartItem.getCost()));
        });
        System.out.println("-------------------------------------------------");
        System.out.println("Sales Taxes:" + decimalFormat.format(cart.getTotalTax()));
        System.out.println("Total:" + decimalFormat.format(cart.getTotalCost()));
        System.out.println("-------------------------------------------------");
        System.out.println("");
        return cart;
    }
}
