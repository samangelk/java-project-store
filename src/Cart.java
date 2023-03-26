package com.ata;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items = new ArrayList<>();
    private double total;
    private double taxRate = 0.1;


    public void addItem(Product p){
        items.add(p);
    }

    public void addPrice(Product p){
        total += p.getPrice();
    }
//It should be called when the shopper selects option 4 in the menu and should print
// the total pre-tax cost of all the items in the cart and the cart items themselves.
// It should also display the after tax cost on a separate line.
    public void showDetails(ArrayList<Product> items){
        System.out.println(String.format("Item Count: %d", items.size()));
        System.out.println("Items:");
        total = 0;
        for(Product item : items){
            System.out.println(String.format("%s : $%.2f",item.getName(), item.getPrice()));
            addPrice(item);
        }

        System.out.println(String.format("Pre-Tax Total: $%.2f", total));
        System.out.println(String.format("Post-Tax Total (10.00% Tax): $%.2f", total*(1- taxRate)));
    }

}
