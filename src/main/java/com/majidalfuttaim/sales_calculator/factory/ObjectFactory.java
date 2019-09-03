package com.majidalfuttaim.sales_calculator.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.majidalfuttaim.sales_calculator.business.TaxCalculatorBusiness;
import com.majidalfuttaim.sales_calculator.business.impl.TaxCalculatorBasicBusinessImpl;
import com.majidalfuttaim.sales_calculator.business.impl.TaxCalculatorImportedBusinessImpl;
import com.majidalfuttaim.sales_calculator.models.Product;
import com.majidalfuttaim.sales_calculator.service.TaxCalculatorService;
import com.majidalfuttaim.sales_calculator.service.impl.TaxCalculatorServiceImpl;

/**
 * Class used to serve the Object for the application.
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class ObjectFactory {
    // scanner for taking input from the terminal.
    private static final Scanner inputScanner;
    // product list contains list of the products
    private static List<Product> products;
    // taxcalculatorService
    private static TaxCalculatorService taxCalculatorService;
    // chain of the business
    private static TaxCalculatorBusiness[] taxCalculatorBusiness = { new TaxCalculatorBasicBusinessImpl(), new TaxCalculatorImportedBusinessImpl() };

    // creating factory as Singleton.
    private ObjectFactory() {
    }

    // Initializing the list and creating
    static {
        inputScanner = new Scanner(System.in);
    }

    public static List<Product> getProducts() {
        if (null != products) {
            return products;
        } else {
            products = new ArrayList<Product>();
            return products;
        }
    }

    public static Scanner getInputscanner() {
        return inputScanner;
    }

    public static TaxCalculatorService getTaxCalculatorService() {
        if (null != taxCalculatorService) {
            return taxCalculatorService;
        } else {
            taxCalculatorService = new TaxCalculatorServiceImpl();
            return taxCalculatorService;
        }
    }
    
    public static TaxCalculatorBusiness[] getTaxCalculatorBusiness() {
        return taxCalculatorBusiness;
    }
}
