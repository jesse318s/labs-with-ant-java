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
public class MainMenu extends State {

    @Override
    public void enter() {
        System.out.println("Welcome to the Main Menu!\n1. New Game\n2. Load Game\n3. Options\n4. Credits\n5. Exit\n");
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
                State.current = State.loadGame;
                State.previous = this;
                return;
            case "3":
                State.current = State.options;
                State.previous = this;
                return;
            case "4":
                State.current = State.credits;
                State.previous = this;
                return;
            case "5":
                System.exit(0);
            default:
                System.out.println("Error; please make a selection from the menu.");
        }
    }

}
