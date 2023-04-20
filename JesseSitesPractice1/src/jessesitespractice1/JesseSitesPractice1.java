/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jessesitespractice1;

/**
 *
 * @author jesse - module 1
 */
public class JesseSitesPractice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create vehicle object array of 4 elements
        Vehicle[] vehicles = new Vehicle[4];

        // create vehicle subclass objects and assign them to vehicles array elements
        vehicles[0] = new Hatchback(2008, "Honda", "Fit", 5, false, 2200);
        vehicles[1] = new Sedan(2003, "Chevy", "Malibu", 5, false, 1000);
        vehicles[2] = new Cruiser(2023, "Indian", "Challenger", 2, 1.7698);
        vehicles[3] = new Touring(2021, "Suzuki", "Hyabusa", 2, 1.34);

        // using a for loop, call display method for all objects in vehicles array to display their properties
        for (int x = 0; x < vehicles.length; x++) {
            vehicles[x].display();
            System.out.println();
        }
    }

}
