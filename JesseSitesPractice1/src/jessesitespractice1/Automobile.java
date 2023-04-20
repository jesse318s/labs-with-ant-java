/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jessesitespractice1;

/**
 *
 * @author jesse
 */
public class Automobile extends Vehicle {

    int numberOfSeats;
    boolean hasManualTransmission;
    double towingCapacity;

    public Automobile(int year, String make, String model,
            int numberOfSeats, boolean hasManualTransmission, double towingCapacity) {
        super(year, make, model);
        this.numberOfSeats = numberOfSeats;
        this.hasManualTransmission = hasManualTransmission;
        this.towingCapacity = towingCapacity;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Number of seats: " + numberOfSeats);
        System.out.println("Has manual transmission: " + hasManualTransmission);
        System.out.println("Towing capacity in pounds: " + towingCapacity);
    }
}
