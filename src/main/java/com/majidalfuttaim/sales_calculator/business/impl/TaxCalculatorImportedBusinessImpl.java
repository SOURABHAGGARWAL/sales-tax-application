package com.majidalfuttaim.sales_calculator.business.impl;

import com.majidalfuttaim.sales_calculator.business.TaxCalculatorBusiness;
import com.majidalfuttaim.sales_calculator.models.Product;

/**
 * Class used to calculate the imported tax for the commodity.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class TaxCalculatorImportedBusinessImpl extends TaxCalculatorBusiness {
    
    private static final double taxRate = 5.00;
    
    @Override
    public boolean taxApplicable(Product product) {
        return product.getImported();
    }

    @Override
    public double getTaxRate() {
        return taxRate;
    }
}
