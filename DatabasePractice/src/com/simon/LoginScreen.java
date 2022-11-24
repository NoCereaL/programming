package com.simon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;

public class LoginScreen {
    public JFrame frame;

    public class panel extends JPanel {
        public JLabel label;
        public JTextField textField;
        public JTextField passwordField;
        public JButton button;
        public JButton signup;
        public JLabel success;
        public JLabel failed;

        public class MySQLConnection {

            public MySQLConnection(String user, String pass) throws IOException {
                String u = null;
                String p = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = null;
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "");
                    System.out.print("Database is connected !");

                    Statement statement = conn.createStatement();

                    String sql = "SELECT username, password FROM signup ";
                    ResultSet result = statement.executeQuery(sql);
                    System.out.println("\nGot Data");

                    while (result.next()){
                        u = result.getString("username");
                        //System.out.println(u);
                        p = result.getString("password");
                        //System.out.println(p);

                        if (textField.getText().equals(u) && passwordField.getText().equals(p)){
                            System.out.println("Login Successful");
                            success.setVisible(true);
                            failed.setVisible(false);
                            System.exit(0);
                        }
                        else {
                            failed.setVisible(true);
                            success.setVisible(false);
                        }
                    }


                    conn.close();
                }
                catch(Exception e) {
                    System.out.print("Did not connect to DB - Error:"+e);
                    File signup = new File("signup.txt");
                    BufferedReader reader = new BufferedReader(new FileReader(signup));
                    Scanner files = new Scanner(new File("signup.txt"));
                    while (files.hasNextLine()) {
                        if (reader.readLine().contains(user)) {
                            if (reader.readLine().contains(pass)) {
                                System.out.println("\nLogin Successful");
                                System.exit(0);
                            }
                        }
                        else {
                            failed.setVisible(true);
                        }
                        files.nextLine();
                    }
                    reader.close();
                }
            }
        }

        public panel(){
            new JPanel();

            Font font = new Font("sans-serif",Font.BOLD,15);

            label = new JLabel("Login in Please");

            Font f = new Font("sans-serif",Font.BOLD, 15);
            success = new JLabel("Login Successful");
            success.setFont(f);
            success.setForeground(Color.green);
            success.setVisible(false);

            failed = new JLabel("Username or password does not exist");
            failed.setFont(f);
            failed.setForeground(Color.red);
            failed.setVisible(false);

            textField = new JTextField(10);
            textField.setFont(font);
            //username = textField.getText();

            passwordField = new JPasswordField(10);
            passwordField.setFont(font);
            //password = passwordField.getText();

            button = new JButton("Login");
            button.setFont(font);
            button.setMargin(new Insets(5,50,5,50));
            button.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        MySQLConnection mySQLConnection = new MySQLConnection(textField.getText(),passwordField.getText());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            });

            signup = new JButton("Signup");
            signup.setFont(font);
            signup.setMargin(new Insets(5,100,5,100));
            signup.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new SignUp();
                    frame.setVisible(false);
                }
            });

            setSize(1366,768);
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.insets = new Insets(5,5,10,5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(label, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            add(textField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            add(passwordField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            add(button, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            add(signup, gbc);

            gbc.gridx = 0;
            gbc.gridy = 5;
            add(success, gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            add(failed, gbc);
        }
    }

    public LoginScreen(){
        frame = new JFrame();

        frame.add(new panel());
        frame.setTitle("Login");
        frame.setSize(1366,768);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}
