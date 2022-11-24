package com.simon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login extends JFrame {

    public class GUI extends JPanel{
        public JLabel label;
        public JButton login;
        public JButton signup;
        public JTextField textField;
        public JTextField passwordField;
        public JLabel incorrect;

        public class MySQL {

            public MySQL() {
                String user; String pass;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = null;
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
                    System.out.println("Connected!!!");

                    String sql = "SELECT username, password FROM signup";

                    Statement statement =  connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);

                    while (resultSet.next()){
                        user = resultSet.getString("username");
                        pass = resultSet.getString("password");

                        if (textField.getText().equals(user) && passwordField.getText().equals(pass)){
                            System.out.println("Login Successful");
                        }
                        else {
                            incorrect.setVisible(true);
                        }
                    }

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

            label = new JLabel("Login Here");

            textField = new JTextField("Enter text");
            textField.setBounds(0,0,200,30);

            passwordField = new JPasswordField("Enter text");

            incorrect = new JLabel("Username of Password does not Exist");
            incorrect.setForeground(Color.red);
            incorrect.setVisible(false);

            login = new JButton("Login");
            login.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MySQL mySQL = new MySQL();
                }
            });

            signup = new JButton("Signup");
            signup.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Signup();
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
            add(login, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            add(incorrect, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            add(signup, gbc);
        }
    }

    public Login(){
        add(new GUI());
        setTitle("Login Screen");
        setSize(1366,768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
