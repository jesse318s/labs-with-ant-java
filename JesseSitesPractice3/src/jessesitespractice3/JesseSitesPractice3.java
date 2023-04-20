/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jessesitespractice3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jesse - module 3
 */
public class JesseSitesPractice3 {

    static int nameCounter;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\n1. Display Data\n2. Add New Entry"
                    + "\n3. Edit Entry\n4. Remove Entry\n5. Exit\n");
            input = in.nextLine();
            System.out.println();

            switch (input) {
                case "1":
                    displayNames();
                    break;
                case "2":
                    addName();
                    break;
                case "3":
                    displayNames();
                    editName();
                    break;
                case "4":
                    displayNames();
                    removeName();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("\nError; please make a selection from "
                            + "the menu.");
                    break;
            }
        }

    }

    public static void displayNames() throws IOException {
        FileReader fr = new FileReader("names.txt");
        BufferedReader br = new BufferedReader(fr);
        String nameOutput;
        nameCounter = 0;

        while ((nameOutput = br.readLine()) != null) {
            nameCounter++;
            System.out.println(nameCounter + ". " + nameOutput);
        }

        br.close();
    }

    public static void addName() throws IOException {
        Scanner in = new Scanner(System.in);
        FileReader fr = new FileReader("names.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("names.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        String nameInput;

        System.out.print("Please enter a name to add to the file: ");
        nameInput = in.nextLine();
        Pattern p = Pattern.compile("^[a-z ]+$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(nameInput);
        boolean lacksSpecial = m.find();

        // check name validation
        while (!lacksSpecial) {
            System.out.print("\nInvalid name; please enter a new name: ");
            nameInput = in.nextLine();
            p = Pattern.compile("^[a-z ]+$", Pattern.CASE_INSENSITIVE);
            m = p.matcher(nameInput);
            lacksSpecial = m.find();
        }

        if (br.readLine() == null) {
            br.close();
            bw.append(nameInput);
            bw.close();

            return;
        }

        br.close();
        bw.append(System.getProperty("line.separator") + nameInput);
        bw.close();
    }

    public static void editName() throws IOException {
        Scanner in = new Scanner(System.in);
        FileReader fr = new FileReader("names.txt");
        BufferedReader br = new BufferedReader(fr);
        String input;
        String nameInput;
        String nameOutput;

        System.out.print("\nPlease enter a name number to edit in the file: ");
        input = in.nextLine();
        System.out.print("Please enter a new name: ");
        nameInput = in.nextLine();
        Pattern p = Pattern.compile("^[a-z ]+$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(nameInput);
        boolean lacksSpecial = m.find();

        // check name validation
        while (!lacksSpecial) {
            System.out.print("\nInvalid name; please enter a new name: ");
            nameInput = in.nextLine();
            p = Pattern.compile("^[a-z ]+$", Pattern.CASE_INSENSITIVE);
            m = p.matcher(nameInput);
            lacksSpecial = m.find();
        }

        String[] fileNames = new String[nameCounter];
        nameCounter = 0;

        while ((nameOutput = br.readLine()) != null) {
            fileNames[nameCounter] = nameOutput;
            nameCounter++;
        }

        br.close();
        FileWriter fw = new FileWriter("names.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        fileNames[Integer.parseInt(input) - 1] = nameInput;
        bw.write(fileNames[0]);

        for (int i = 1; i < fileNames.length; i++) {
            bw.write(System.getProperty("line.separator") + fileNames[i]);
        }

        bw.close();
    }

    public static void removeName() throws IOException {
        Scanner in = new Scanner(System.in);
        FileReader fr = new FileReader("names.txt");
        BufferedReader br = new BufferedReader(fr);
        int input;
        String nameOutput;

        System.out.print("\nPlease enter a name number to remove from the file: ");
        input = Integer.parseInt(in.nextLine());
        String[] fileNames = new String[nameCounter];
        nameCounter = 0;

        while ((nameOutput = br.readLine()) != null) {
            fileNames[nameCounter] = nameOutput;
            nameCounter++;
        }

        br.close();
        FileWriter fw = new FileWriter("names.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        fileNames[input - 1] = null;

        if (input != 1) {
            bw.write(fileNames[0]);
        }

        for (int i = 1; i < fileNames.length; i++) {
            if (i == input - 1) {
                continue;
            }

            if (i == input && input == 1) {
                bw.write(fileNames[1]);

                continue;
            }

            bw.write(System.getProperty("line.separator") + fileNames[i]);
        }

        bw.close();
    }

}
