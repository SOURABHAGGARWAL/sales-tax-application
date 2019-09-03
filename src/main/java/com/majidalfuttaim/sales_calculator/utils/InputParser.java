package com.majidalfuttaim.sales_calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

import com.majidalfuttaim.sales_calculator.models.Cart;
import com.majidalfuttaim.sales_calculator.models.CartItem;
import com.majidalfuttaim.sales_calculator.models.Product;

/**
 * Class used to parse the input given by the user.
 * 
 * @author sourabhaggarwal on 3-SEP-2019
 *
 */
public class InputParser {
    private static final String ITEM_ENTRY_REGEX = "(\\d+) ([\\w\\s]* )at (\\d+.\\d{2})";

    private void Inputparse() {
        
    }
    /**
     * Method used to set the cart reading input.
     * 
     * @param listOfItemfullDesc
     * @return
     */
    public static Cart parseCart(String[] listOfItemfullDesc) {
        List<CartItem> cartItemList = new ArrayList<CartItem>();
        for (int i = 0; i < listOfItemfullDesc.length; i++) {
            cartItemList.add(parseCartItem(listOfItemfullDesc[i]));
        }
        return new Cart(cartItemList);
    }

    /**
     * Method used to parse the cart items and set values to the model.
     * 
     * @param itemDescription
     * @return
     */
    public static CartItem parseCartItem(String itemDescription) {
        Pattern pattern = Pattern.compile(ITEM_ENTRY_REGEX);
        Matcher matcher = pattern.matcher(itemDescription);
        if (matcher.matches()) {
            int quantity = Integer.parseInt(matcher.group(1).toString());
            double price = Double.parseDouble(matcher.group(3).toString());
            String itemName = matcher.group(2).toString();
            Product product = new Product(itemName, price);
            CartItem cartItem = new CartItem(product, quantity);
            return cartItem;
        }
        return null;
    }
}
