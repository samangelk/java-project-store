package com.ata;

import java.util.Scanner;

/**
 * Menu class is responsible for greeting the user, showing a menu
 * to the user for interaction with the application.
 * The class maintains a String[] array of menu options, which it
 * uses for printing the menu to standard out.
 * The class is also responsible for responding to user interaction
 * with respect to its menu.
 */
public class Menu {
    private String[] menuOptions = {"Exit", "List Products", "Buy Product", "Find Product", "Show Cart", "Checkout"};

    private Shop shop;
    private Scanner scanner;

    /**
     * Class constructor, which expects a Scanner object
     * It allows for the user to specify how a Scanner is to
     * be configured outside this class and for basic inversion of control.
     * @param scanner takes in a Scanner object to initialize
     */
    public Menu(Scanner scanner, Shop shop) {
        this.scanner = scanner;
        this.shop = shop;
    }


    /**
     * Prints the menu to standard output, using the class's menuOptions array.
     * It accepts user input using the encapsulated Scanner instance.
     * All output is printed to standard out.
     * All input is collected from standard in.
     */
    public void executeMenu() {
        printMenu();
        int o = getNextIntFromUser();
        while (o != 0) {

            if (o == 1) {
                shop.printProducts();
                printMenu();
            } else if (o == 2) {
                System.out.println(shop.printProducts());
                System.out.println("Please enter the ID of the product you would like to purchase:");
                int itemID = getNextIntFromUser();
                // get Product from ID
                if (shop.getProductName(itemID) != null){
                    cart.addItem(shop.getProductName(itemID));
                    System.out.println(shop.getProductName(itemID) + " has been added to your cart.");
                } else {
                    System.out.println("That item ID is invalid and could not be added to the cart.");
                }
            } else if (o == 3) {
                System.out.println("Enter the item to search for:");
                String itemToFind = getNextStringLineFromUser();
                int productID = shop.findProduct(itemToFind);
                if (productID > -1) {
                    System.out.println(shop.getProductName(productID) + " was found and its product id is " + productID);
                    printMenu();
                } else {
                    System.out.println("That product was not found.");
                    printMenu();
                }

            }

            o = getNextIntFromUser();
        }

        // handleShopperMenuOptionSelection();
        exit();
    }


    /**
     * Asks the user to enter their name.
     * After the user provides their name, it outputs a greeting to the user to standard out.
     */
    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        String shopName = "T-Shirt Mart";

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



