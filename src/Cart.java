package com.ata;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items = new ArrayList<>();
    private double total;
    private double taxRate;


    public ArrayList addItem(Product p){
        Product newProduct = new Product(p.getID(), p.getName(), p.getPrice());
        items.add(newProduct);
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
        total = 0;
        for(Product items : item){
            System.out.println(String.format("%s : $%.2f",item.getName(), item.getPrice()));
            total.addPrice(item.getPrice());
        }

        System.out.println(String.format("Pre-Tax Total: $%.2f", total));
        System.out.println(String.format("Post-Tax Total (10.00% Tax): $%.2f", total*0.9));
    }

}
