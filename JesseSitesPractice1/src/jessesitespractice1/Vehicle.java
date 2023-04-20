/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jessesitespractice1;

/**
 *
 * @author jesse
 */
public class Vehicle {

    int year;
    String make;
    String model;

    public Vehicle(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public void display() {
        System.out.println("Year: " + year);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
    }
}
