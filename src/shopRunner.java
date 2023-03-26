package com.ata;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;
import javax.annotation.Nullable;

/**
 * The ShopRunner class is the main entry point for the application.
 * It encapsulates a Menu, providing it with a Scanner configured
 * with System.in to allow the menu to read from standard in.
 * When the application starts, the menu's greet and show methods are called.
 */
public class ShopRunner {
    /**
     * Main entry point to the application.
     * Asks the menu's greeting to be printed to standard out by calling its greet method.
     * Asks the menu to be shown by calling its show method.
     * @param args Command line arguments to the application
     */
    public static void main(@Nullable ArrayList<Product> args) {
        ArrayList<Product> productArr = new ArrayList<>();

        productArr.add(new Product(0,"Crew Neck", 20));
        productArr.add(new Product(1,"V-Neck", 11));
        productArr.add(new Product(2,"Polo", 12));
        productArr.add(new Product(3,"Boat Neck",13));
        productArr.add(new Product(4,"Tank Top", 14));


        Menu menu = new Menu(
                new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8"))),
                new Shop("T-Shirt Mart", productArr)
        );

        menu.greet();
        menu.executeMenu();

    }
}
