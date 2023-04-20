/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jessesitespractice4b;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jesse - module 4
 */
public class JesseSitesPractice4B {

    static JFileChooser fcJar = new JFileChooser();
    static JFileChooser fcIcon = new JFileChooser();
    static JCheckBox cbInstallPath = new JCheckBox();
    static JCheckBox cbDesktopShortcut = new JCheckBox();
    static JCheckBox cbStartShortcut = new JCheckBox();
    static JTextField tfVersionNumber = new JTextField();
    static JTextArea taDescription = new JTextArea();
    static JTextField tfAppName = new JTextField();
    static JTextField tfVendorName = new JTextField();
    static JTextField tfCopyright = new JTextField();
    static JLabel lblStatus = new JLabel();
    static String packageCommand = "jpackage ";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JLabel lblJar = new JLabel();
        JLabel lblIcon = new JLabel();
        JLabel lblInstallPath = new JLabel();
        JLabel lblDesktopShortcut = new JLabel();
        JLabel lblStartShortcut = new JLabel();
        JLabel lblVersionNumber = new JLabel();
        JLabel lblDescription = new JLabel();
        JLabel lblAppName = new JLabel();
        JLabel lblVendorName = new JLabel();
        JLabel lblCopyright = new JLabel();
        JButton btnCreatePackage = new JButton();

        JFrame jframe = new JFrame();
        jframe.setBounds(50, 50, 1400, 700);
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setIconImage(new ImageIcon(JesseSitesPractice4B.class.getResource("/icon.png")).getImage());
        jframe.getContentPane().setBackground(Color.YELLOW);

        lblJar.setBounds(50, 25, 100, 18);
        lblJar.setText("Jar");
        lblJar.setForeground(Color.MAGENTA);
        jframe.add(lblJar);
        fcJar.setBounds(50, 50, 600, 300);
        jframe.add(fcJar);

        lblIcon.setBounds(750, 25, 500, 18);
        lblIcon.setText("Icon");
        lblIcon.setForeground(Color.MAGENTA);
        jframe.add(lblIcon);
        fcIcon.setBounds(750, 50, 600, 300);
        fcIcon.addActionListener((ActionEvent e) -> {
            if (fcIcon.getSelectedFile() == null) {
                lblIcon.setText("Icon");
                return;
            }

            lblIcon.setText("Icon: " + fcIcon.getSelectedFile().getName().substring(
                    0, fcIcon.getSelectedFile().getName().lastIndexOf(".")));
        });
        jframe.add(fcIcon);

        lblInstallPath.setBounds(50, 390, 100, 18);
        lblInstallPath.setText("Install Path:");
        lblInstallPath.setForeground(Color.MAGENTA);
        jframe.add(lblInstallPath);
        cbInstallPath.setBounds(125, 375, 50, 50);
        cbInstallPath.setBackground(Color.YELLOW);
        jframe.add(cbInstallPath);

        lblDesktopShortcut.setBounds(250, 390, 150, 18);
        lblDesktopShortcut.setText("Desktop Shortcut:");
        lblDesktopShortcut.setForeground(Color.MAGENTA);
        jframe.add(lblDesktopShortcut);
        cbDesktopShortcut.setBounds(375, 375, 50, 50);
        cbDesktopShortcut.setSelected(true);
        cbDesktopShortcut.setBackground(Color.YELLOW);
        jframe.add(cbDesktopShortcut);

        lblStartShortcut.setBounds(450, 390, 100, 18);
        lblStartShortcut.setText("Start Shortcut:");
        lblStartShortcut.setForeground(Color.MAGENTA);
        jframe.add(lblStartShortcut);
        cbStartShortcut.setBounds(550, 375, 50, 50);
        cbStartShortcut.setBackground(Color.YELLOW);
        jframe.add(cbStartShortcut);

        lblVersionNumber.setBounds(50, 425, 100, 18);
        lblVersionNumber.setText("Version Number");
        lblVersionNumber.setForeground(Color.MAGENTA);
        jframe.add(lblVersionNumber);
        tfVersionNumber.setBounds(50, 450, 50, 18);
        jframe.add(tfVersionNumber);

        lblDescription.setBounds(190, 425, 100, 18);
        lblDescription.setText("Description");
        lblDescription.setForeground(Color.MAGENTA);
        jframe.add(lblDescription);
        taDescription.setBounds(150, 450, 150, 36);
        jframe.add(taDescription);

        lblAppName.setBounds(350, 425, 100, 18);
        lblAppName.setText("App Name");
        lblAppName.setForeground(Color.MAGENTA);
        jframe.add(lblAppName);
        tfAppName.setBounds(350, 450, 100, 18);
        jframe.add(tfAppName);

        lblVendorName.setBounds(50, 500, 100, 18);
        lblVendorName.setText("Vendor Name");
        lblVendorName.setForeground(Color.MAGENTA);
        jframe.add(lblVendorName);
        tfVendorName.setBounds(50, 525, 100, 18);
        jframe.add(tfVendorName);

        lblCopyright.setBounds(200, 500, 100, 18);
        lblCopyright.setText("Copyright");
        lblCopyright.setForeground(Color.MAGENTA);
        jframe.add(lblCopyright);
        tfCopyright.setBounds(200, 525, 100, 18);
        jframe.add(tfCopyright);

        btnCreatePackage.setBounds(50, 575, 200, 50);
        btnCreatePackage.setText("Create Package");
        btnCreatePackage.addActionListener((ActionEvent e) -> {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (fcJar.getSelectedFile() == null) {
                        return;
                    }
                    lblStatus.setText("Status: packaging...");
                    createPackageCommand();
                    executePackageCommand();
                }
            });
            t.start();
        });
        btnCreatePackage.setBackground(Color.MAGENTA);
        btnCreatePackage.setForeground(Color.YELLOW);
        jframe.add(btnCreatePackage);

        lblStatus.setBounds(100, 625, 200, 18);
        lblStatus.setText("Status: standing by");
        lblStatus.setForeground(Color.MAGENTA);
        jframe.add(lblStatus);

        jframe.setVisible(true);
    }

    public static void createPackageCommand() {
        packageCommand = packageCommand + "--input dist --main-jar " + '"'
                + fcJar.getSelectedFile().getName() + '"';

        if (fcIcon.getSelectedFile() != null) {
            packageCommand = packageCommand + " --icon " + '"'
                    + fcIcon.getSelectedFile() + '"';
        }

        if (cbInstallPath.isSelected()) {
            packageCommand = packageCommand + " --win-dir-chooser";
        }

        if (cbDesktopShortcut.isSelected()) {
            packageCommand = packageCommand + " --win-shortcut";
        }

        if (cbStartShortcut.isSelected()) {
            packageCommand = packageCommand + " --win-menu";
        }

        if (!tfVersionNumber.getText().equals("")) {
            packageCommand = packageCommand + " --app-version " + tfVersionNumber.getText();
        }

        if (!taDescription.getText().equals("")) {
            packageCommand = packageCommand + " --description " + '"'
                    + taDescription.getText().trim() + '"';
        }

        if (!tfAppName.getText().equals("")) {
            packageCommand = packageCommand + " --name " + '"'
                    + tfAppName.getText().trim() + '"';
        }

        if (!tfVendorName.getText().equals("")) {
            packageCommand = packageCommand + " --vendor " + '"'
                    + tfVendorName.getText().trim() + '"';
        }

        if (!tfCopyright.getText().equals("")) {
            packageCommand = packageCommand + " --copyright " + '"'
                    + tfCopyright.getText().trim() + '"';
        }
    }

    public static void executePackageCommand() {
        try {
            Process p = Runtime.getRuntime().exec(packageCommand, null,
                    new File(fcJar.getSelectedFile().getAbsolutePath().substring(0,
                            fcJar.getSelectedFile().getAbsolutePath().length()
                            - fcJar.getSelectedFile().getName().length() - 5)));
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";

            packageCommand = "jpackage ";

            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            p.waitFor(); //blocks the thread until the process is done.    
            lblStatus.setText("Status: complete");
        } catch (Exception x) {
            packageCommand = "jpackage ";
            lblStatus.setText("Status: standing by");
            x.printStackTrace();
        }
    }
}
