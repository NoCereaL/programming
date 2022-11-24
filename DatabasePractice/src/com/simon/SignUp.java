package com.simon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUp {
    public JFrame frame;

    public class GUI extends JPanel{
        public JLabel label;
        public JTextField textField;
        public JTextField passwordField;
        public JButton signup;

        public class MySQL {
            public MySQL(String user, String password) throws IOException {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String username = "root";
                    String pass = "";
                    String db = "jdbc:mysql://localhost/login";

                    Connection con = null;
                    con = DriverManager.getConnection(db,username,pass);
                    System.out.println("Connection Successful");

                    String sql = "INSERT INTO signup(username, password, role)" + "VALUES(?,?,0)";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);

                    preparedStatement.setString(1,user);
                    preparedStatement.setString(2,password);

                    preparedStatement.executeUpdate();
                    System.out.println("Data Successfully added to DB");
                    con.close();
                } catch (ClassNotFoundException | SQLException ex){
                    System.out.println("Error - Could not connect to DB");
                    System.out.println("Data Added to signup.txt file");
                    System.out.println("Alternative Signup Successful");
                    BufferedWriter writer = new BufferedWriter(new FileWriter("signup.txt", true));

                    writer.append("Username: " +user +"\n");
                    writer.append("Password: " +password +"\n");
                    writer.close();
                }
            }
        }

        public GUI(){
            new JPanel();
            setSize(1366,768);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            label = new JLabel("Pleas Signup Here:");

            textField = new JTextField(10);

            passwordField = new JPasswordField(10);

            signup = new JButton("Signup");
            signup.setMargin(new Insets(5,50,5,50));
            signup.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        MySQL mySQL = new MySQL(textField.getText(), passwordField.getText());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    new LoginScreen();
                    frame.setVisible(false);
                }
            });

            gbc.insets = new Insets(5,5,5,5);
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
            add(signup, gbc);

        }

    }
    public SignUp(){
        frame = new JFrame();

        frame.add(new GUI());
        frame.setTitle("Signup Screen");
        frame.setSize(1366,768);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
