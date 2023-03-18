package com.ata;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items = new ArrayList<>();
    private double total;
    private double taxRate;


    public ArrayList addItem(Product p){
        items.add(p.getName());
        return items;
    }

    public double addPrice(Product p){
        total += p.getPrice();
        return total;
    }
//It should be called when the shopper selects option 4 in the menu and should print
// the total pre-tax cost of all the items in the cart and the cart items themselves.
// It should also display the after tax cost on a separate line.
    public void showDetails(Product p){
        System.out.println("Item Count: " + items.length.toString);
        System.out.println("Items:");

    }

}
