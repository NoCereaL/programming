package com.simon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Practice extends JFrame {
    public JLabel label;
    public JLabel label2;
    public JTextField textField;
    public JPasswordField passwordField;
    public JButton login;

    public class panelView extends JPanel{

        public void MYSQLLogin(String username, String password){
            String user = null;
            String pass = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/login", "root", "");
                System.out.println("Connected");

                Statement statement = connection.createStatement();

                String sql = "SELECT username, password FROM signup ";
                ResultSet result = statement.executeQuery(sql);
                System.out.println("Data Collected");
                while (result.next()){
                    user = result.getString("username");
                    pass = result.getString("password");

                    if(textField.getText().equals(user) && passwordField.getText().equals(pass)){
                        label.setText("Welldone, Data Collected");
                    }
                }
                connection.close();
            } catch (Exception e){
                System.out.println("Error: Did not Connect");
                e.printStackTrace();
            }
        }

        panelView(){
            label = new JLabel("Simon's August 2021 Practice");
            label.setFont(new Font("Arial", Font.BOLD, 30));

            label2 = new JLabel("Please Login Here");
            label2.setFont(new Font("Arial", Font.ITALIC, 20));

            textField = new JTextField("Enter Username Here");
            textField.setSize(100,30);

            passwordField = new JPasswordField("Enter Password Here");
            passwordField.setBounds(0,0, 150, 30);

            login = new JButton("Login");
            login.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MYSQLLogin(textField.getText(), passwordField.getText());

                }
            });

            GridBagConstraints gbc = new GridBagConstraints();
            setLayout(new GridBagLayout());

            gbc.insets = new Insets(5,5,5,5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(label, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            add(label2, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            add(textField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            add(passwordField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            add(login, gbc);
        }
    }

    Practice(){
        add(new panelView(), BorderLayout.CENTER);
        setTitle("Practice");
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Practice();
    }
}
