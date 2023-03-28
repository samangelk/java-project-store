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

    public int getCartSize(){
        return items.size();
    }
//It should be called when the shopper selects option 4 in the menu and should print
// the total pre-tax cost of all the items in the cart and the cart items themselves.
// It should also display the after tax cost on a separate line.
    public void showDetails() {
        System.out.println(String.format("--Cart--%nItem Count: %d", items.size()));
        System.out.println("Items:");
        total = 0;
        for (Product item : items) {
            System.out.println(String.format("%s: $%.2f", item.getName(), item.getPrice()));
            addPrice(item);
        }

        System.out.println(String.format("%nPre-Tax Total: $%.2f", total));
        double afterTaxTotal = total * (1-taxRate);
        System.out.println(String.format("Post-Tax Total (10.00%% Tax): $%.2f", afterTaxTotal));
    }

    private void emptyCart(){
        items.clear();
    }

    public void checkout(){
        System.out.println(String.format("Your total is $%.2f", total));
        System.out.println("Thank you for shopping at T-Shirt Mart.");
        emptyCart();
    }

}
