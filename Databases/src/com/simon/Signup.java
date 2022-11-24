package com.simon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Signup extends JFrame {

    public class GUI extends JPanel{
        public JLabel label;
        public JButton signup;
        public JTextField textField;
        public JPasswordField passwordField;

        public class MySQL {

            public MySQL(String user, String pass) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = null;
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
                    System.out.println("Connected!!!");

                    String sql = "INSERT INTO signup(username, password, role)" + "VALUES(?,?,0)";

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);

                    preparedStatement.setString(1, user);
                    preparedStatement.setString(2, pass);

                    preparedStatement.executeUpdate();
                    System.out.println("Signup Successful");
                    connection.close();
                } catch (Exception e){
                    System.out.println("Error");
                    System.exit(0);
                }
            }
        }

        public GUI(){
            new JPanel();
            setLayout(new GridBagLayout());

             label = new JLabel("Sign up Here");

             textField = new JTextField("Enter text");
             textField.setBounds(0,0,200,30);

             passwordField = new JPasswordField("Enter text");

             signup = new JButton("Signup");
             signup.addActionListener(new AbstractAction() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     MySQL mySQL = new MySQL(textField.getText(), passwordField.getText());
                 }
             });

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.insets = new Insets(5,5,5,5);
            gbc.gridx = 0;
            gbc.gridy =0;
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

    public Signup(){
        add(new GUI());
        setTitle("Login Screen");
        setSize(1366,768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Signup();
    }
}
