package com.ata;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> products = new ArrayList<>();
    private String name;
    private Cart cart;
    public Shop(String name, ArrayList<Product> products) {
        this.name = name;
        this.products  = products;
    }

    public void printProducts() {
        System.out.println("--Products--");
        for (Product p : products) {
            System.out.println("ID " + p.getID() + ": " + p.getName() + " - $" + p.getPrice());
        }
    }

    public Product getProduct(int id) {
        return products.get(id);
    }
    public int getProductSize() {
        return products.size();
    }
   // get shop name
    public String getName(){
        return name;
    }
    public int findProduct(String searchText) {
        int id = 0;
        for (int i = 0; i < products.size(); i++) {
            if (searchText.equals(products.get(i).getName())) {
                id = i;
                break;
            } else {
                id = -1;
            }
        }
        return id;
    }
}





