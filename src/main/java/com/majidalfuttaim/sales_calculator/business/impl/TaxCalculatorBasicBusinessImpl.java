package com.majidalfuttaim.sales_calculator.business.impl;

import java.util.Arrays;
import java.util.Map.Entry;

import com.majidalfuttaim.sales_calculator.business.TaxCalculatorBusiness;
import com.majidalfuttaim.sales_calculator.models.Product;
import com.majidalfuttaim.sales_calculator.models.ProductType;

/**
 * Class used to calculate the basic tax for the commodity.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class TaxCalculatorBasicBusinessImpl extends TaxCalculatorBusiness {

    private static final double taxRate = 10.00;

    // Checking for the product type and set is exempted or not.
    @Override
    public boolean taxApplicable(Product product) {
        for (Entry<ProductType, String[]> productType : Product.productTypes.entrySet()) {
            if (Arrays.stream(Product.productTypes.get(productType.getKey())).parallel().anyMatch(product.getName().toLowerCase()::contains)) {
                return !product.getExempted(productType.getKey());
            }
        }
        return true;
    }

    // Set the basic tax rate for the application.
    @Override
    public double getTaxRate() {
        return taxRate;
    }
}
