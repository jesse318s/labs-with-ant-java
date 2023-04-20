/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jessesitespractice4a;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jesse - module 4
 */
public class JesseSitesPractice4A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jframe = new JFrame("Jesse Sites Practice 4");

        // window
        jframe.setBounds(100, 100, 300, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);

        // name label
        JLabel labelName = new JLabel("Enter Name: ");
        labelName.setBounds(10, 10, 125, 18);
        jframe.add(labelName);

        // name text field
        JTextField nameField = new JTextField();
        nameField.setBounds(labelName.getWidth(), 10, 125, 18);
        jframe.add(nameField);

        // password label
        JLabel labelPassword = new JLabel("Enter Password: ");
        labelPassword.setBounds(10, 38, 125, 18);
        jframe.add(labelPassword);

        // password text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(labelPassword.getWidth(), 38, 125, 18);
        passwordField.setEchoChar('•');
        jframe.add(passwordField);

        // save button
        JButton buttonSave = new JButton("Save");
        buttonSave.setBounds(10, 75, 75, 50);
        buttonSave.setBackground(Color.GREEN);
        buttonSave.addActionListener((ActionEvent e) -> {
            try {
                save(nameField.getText(), passwordField.getText());
            } catch (IOException exception) {
                System.out.println(exception);
            }
        });
        buttonSave.setVisible(false);
        jframe.add(buttonSave);

        // password listener
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (validatePassword(passwordField.getText())) {
                    buttonSave.setVisible(true);
                    passwordField.setForeground(Color.GREEN);
                    return;
                }

                buttonSave.setVisible(false);
                passwordField.setForeground(Color.RED);
            }
        });

        // quit button
        JButton buttonQuit = new JButton("Quit");
        buttonQuit.setBounds(buttonSave.getWidth() + 20, 75, 75, 50);
        buttonQuit.setForeground(Color.RED);
        buttonQuit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        jframe.add(buttonQuit);

        // image
        JLabel labelImage = new JLabel();
        labelImage.setIcon(new ImageIcon(JesseSitesPractice4A.class.getResource("/cyber_snail.png")));
        labelImage.setBounds(10, 150, 100, 100);
        jframe.add(labelImage);

        jframe.setVisible(true);
    }

    public static void save(String name, String password) throws IOException {
        FileWriter fw = new FileWriter("info.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(name + "," + password + System.getProperty("line.separator"));
        bw.close();
    }

    public static Boolean validatePassword(String password) {
        Pattern p = Pattern.compile("^[a-z0-9]+$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean lacksSpecial = m.find();
        p = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
        m = p.matcher(password);
        boolean hasLetter = m.find();
        p = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
        m = p.matcher(password);
        boolean hasNumber = m.find();

        if (password.length() < 6 || lacksSpecial || !hasNumber || !hasLetter) {
            return false;
        }

        return true;
    }
}
