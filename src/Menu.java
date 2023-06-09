package com.ata;

import java.util.Scanner;

public class Menu {
    private String[] menuOptions = {"Exit", "List Products", "Buy Product", "Find Product", "Show Cart", "Checkout"};

    private Shop shop;
    private Cart cart = new Cart();
    private Scanner scanner;

    public Menu(Scanner scanner, Shop shop) {
        this.scanner = scanner;
        this.shop = shop;
    }

    public void executeMenu() {
        printMenu();
        int o = getNextIntFromUser();
        while (o != 0) {

            if (o == 1) {
                shop.printProducts();
                printMenu();
            } else if (o == 2) {

                System.out.println("Please enter the ID of the product you would like to purchase:");
                int itemID = getNextIntFromUser();
                // get Product from ID
                if (itemID < shop.getProductSize()){
                    cart.addItem(shop.getProduct(itemID));
                    System.out.println(shop.getProduct(itemID).getName() + " has been added to your cart.");
                } else {
                    System.out.println("That item ID is invalid and could not be added to the cart.");
                }
                printMenu();
            } else if (o == 3) {
                System.out.println("Enter the item to search for:");
                String itemToFind = getNextStringLineFromUser();
                int productID = shop.findProduct(itemToFind);
                if (productID > -1) {
                    System.out.println(shop.getProduct(productID).getName() + " was found and its product id is " + productID);
                    printMenu();
                } else {
                    System.out.println("That product was not found.");
                    printMenu();
                }

            } else if (o ==4) {
                if (cart.getCartSize() == 0) {
                    System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
                } else {
                    cart.showDetails();
                }
                printMenu();
            } else {
                if (cart.getCartSize() == 0) {
                    System.out.println("Your cart is currently empty. Please add at least one product to check out.");

                } else {
                    cart.checkout();
                }
                printMenu();
            }

            o = getNextIntFromUser();
        }

        exit();
    }



    /**
     * Asks the user to enter their name.
     * After the user provides their name, it outputs a greeting to the user to standard out.
     */
    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        String shopName = shop.getName();
        System.out.println("Welcome " + name + " to " + shopName);
    }

    /**
     * Prints the menu header and menu options.
     */
    private void printMenu() {
        System.out.println();
        System.out.println("--Main Menu--");
        System.out.println("Select an option using one of the numbers shown");
        System.out.println();
        //String[] menuOptions = {};

        for (int i = 0; i < menuOptions.length; i++) {
            System.out.print(i + ": ");
            System.out.println(menuOptions[i]);
        }
    }


    /**
     * Prints an exit statement and closes the scanner object.
     */
    private void exit() {
        System.out.println("Exiting now. Goodbye.");
        scanner.close();
    }

    /**
     * Collects next user-entered int.
     * @return integer value denoting the user selection
     */
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }

    /**
     * Skips a line of empty input from the scanner's input stream
     * and then returns the next available line.
     * @return string representing the line of input typed by the user
     */
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}



