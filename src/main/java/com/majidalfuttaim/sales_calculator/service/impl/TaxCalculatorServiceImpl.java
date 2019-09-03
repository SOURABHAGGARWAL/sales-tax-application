package com.majidalfuttaim.sales_calculator.service.impl;

import com.majidalfuttaim.sales_calculator.business.TaxCalculatorBusiness;
import com.majidalfuttaim.sales_calculator.factory.ObjectFactory;
import com.majidalfuttaim.sales_calculator.models.CartItem;
import com.majidalfuttaim.sales_calculator.service.TaxCalculatorService;

/**
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class TaxCalculatorServiceImpl implements TaxCalculatorService {

    /**
     * Method used to calculate the cart item tax.
     * 
     * @param cartItem
     */
    public void calculateItemTax(CartItem cartItem) {
        double calculatedTaxes = 0;
        for (TaxCalculatorBusiness taxCalculatorBusiness : ObjectFactory.getTaxCalculatorBusiness()) {
            if (taxCalculatorBusiness.taxApplicable(cartItem.getProduct())) {
                double tax = taxCalculatorBusiness.calculateTax(cartItem.getProduct());
                calculatedTaxes = calculatedTaxes + tax;
            }
        }
        cartItem.setTax(calculatedTaxes * cartItem.getQuantity());
    }

    /**
     * Method used to calculate the cost of the item in the cart
     * 
     * @param cartItem
     */
    public void calculateItemCost(CartItem cartItem) {
        cartItem.setCost((cartItem.getProduct().getPrice() * cartItem.getQuantity()) + cartItem.getTax());
    }

}
