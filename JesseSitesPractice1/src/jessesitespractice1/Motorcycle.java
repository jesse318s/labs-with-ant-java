/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jessesitespractice1;

/**
 *
 * @author jesse
 */
public class Motorcycle extends Vehicle {

    int wheelCount;
    double engineSize;

    public Motorcycle(int year, String make, String model,
            int wheelCount, double engineSize) {
        super(year, make, model);
        this.wheelCount = wheelCount;
        this.engineSize = engineSize;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Wheel count: " + wheelCount);
        System.out.println("Engine size in liters: " + engineSize);
    }
}
