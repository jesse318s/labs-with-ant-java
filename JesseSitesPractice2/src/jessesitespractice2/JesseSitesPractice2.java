/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jessesitespractice2;

/**
 *
 * @author jesse - module 2
 */
public class JesseSitesPractice2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create state subclass instances
        State.mainMenu = new MainMenu();
        State.options = new Options();
        State.level1 = new Level1();
        State.level2 = new Level2();
        State.level3 = new Level3();
        State.saveGame = new SaveGame();
        State.loadGame = new LoadGame();
        State.credits = new Credits();
        State.current = State.mainMenu;

        // run state machine
        while (true) {
            State.current.enter();
            State.current.update();
        }
    }

}
