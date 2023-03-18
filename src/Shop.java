package com.ata;
public class Shop {
    private Product[] products ;
    public Shop(Product[] products) {
        this.products  = products;
    };
    public void printProducts() {
        System.out.println("--Products--");
        for (int i = 0; i < products.length; i++) {
            System.out.println("ID " + String.valueOf(i) + ": " + products[i].getName() + " - $" + products[i].getPrice());
        }
    }

    public String getProductName(int id) {
        return products[id].getName();
    }

    public int findProduct(String searchText) {
        int id = 0;
        for (int i = 0; i < products.length; i++) {
            if (searchText.equals(products[i].getName())) {
                id = i;
                break;
            } else {
                id = -1;
            }
        }
        return id;
    }
}





