package com.majidalfuttaim.sales_calculator.business;

import com.majidalfuttaim.sales_calculator.models.Product;

/**
 * Class used to calculate the tax for the items, all the 
 * Implementing class for the class will automatically participate in tax calculation.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public abstract class TaxCalculatorBusiness {

    public abstract boolean taxApplicable(Product item);

    /**
     * Method will calculate tax for the application.
     * 
     * @param product
     */
    public double calculateTax(Product product) {
        if (taxApplicable(product)) {
            double tax = (product.getPrice() * getTaxRate()) / 100;
            tax = Math.ceil(tax / 0.05) * 0.05;
            return tax;
        }
        return 0;
    }

    public abstract double getTaxRate();
}
