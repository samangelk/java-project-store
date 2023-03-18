package com.ata;

public class Car {
    // TODO: Add attributes from UML diagram below
    private String color;
    private String make;
    private String model;
    private Printer printer;




    // TODO: Add constructor from UML diagram below
    public Car(String color, String make, String model){
        this.color = color;
        this.make = make;
        this.model = model;
        this.printer = new Printer();
    }



    // TODO: Add getter methods from UML diagram below
    public String getColor(){
        return color;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }


    // TODO: Add the start method from UML below
    public void start(){
        // printer.print(Starting, color, make, model);
    }


    // TODO: Add the stop method from UML below
    public void stop(){
        // printer.print(Stoping, color, make, model);
    }
}
