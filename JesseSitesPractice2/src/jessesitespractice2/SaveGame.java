/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jessesitespractice2;

import java.util.Scanner;

/**
 *
 * @author jesse
 */
public class SaveGame extends State {

    @Override
    public void enter() {
        System.out.println("Welcome to the Save Game Menu!\n1. Return to Level\n");
    }

    @Override
    public void update() {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        System.out.println();

        switch (input) {
            case "1":
                State.current = State.previous;
                State.previous = this;
                return;
            default:
                System.out.println("Error; please make a selection from the menu.");
        }
    }

}
