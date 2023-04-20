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
public abstract class State {

    static State mainMenu, options, level1, level2, level3, saveGame, loadGame, credits,
            current, previous;

    public abstract void enter();

    public abstract void update();
}
