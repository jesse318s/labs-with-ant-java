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
public class LoadGame extends State {

    @Override
    public void enter() {
        System.out.println("Welcome to the Load Game Menu!\n1. Level 1\n2. Level 2\n3. Level 3\n");
    }

    @Override
    public void update() {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        System.out.println();

        switch (input) {
            case "1":
                State.current = State.level1;
                State.previous = this;
                return;
            case "2":
                State.current = State.level2;
                State.previous = this;
                return;
            case "3":
                State.current = State.level3;
                State.previous = this;
                return;
            default:
                System.out.println("Error; please make a selection from the menu.");
        }
    }

}
