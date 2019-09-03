package com.majidalfuttaim.sales_calculator.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class used to hold the product data.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 5955952492272814815L;

    private String name;
    private Double price;
    private Boolean imported;
    private Boolean exempted;
    public static Map<ProductType, String[]> productTypes = new HashMap<ProductType, String[]>();

    static {
        String[] food = { "chocolate", "chocolates" };
        productTypes.put(ProductType.Food, food);
        String[] medical = { "pills" };
        productTypes.put(ProductType.Medical, medical);
        String[] book = { "book" };
        productTypes.put(ProductType.Book, book);
    }

    public Product(String name, Double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getImported() {
        return name.toLowerCase().contains("imported");
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price  + ", imported=" + imported + ", exempted=" + exempted + "]";
    }

    public String displayProduct() {
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((exempted == null) ? 0 : exempted.hashCode());
        result = prime * result + ((imported == null) ? 0 : imported.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (exempted == null) {
            if (other.exempted != null)
                return false;
        } else if (!exempted.equals(other.exempted))
            return false;
        if (imported == null) {
            if (other.imported != null)
                return false;
        } else if (!imported.equals(other.imported))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

   public Boolean getExempted(ProductType productType) {
        return productTypes.containsKey(productType) &&
                Arrays.stream(productTypes.get(productType)).parallel().anyMatch(name.toLowerCase()::contains);
    }
}
