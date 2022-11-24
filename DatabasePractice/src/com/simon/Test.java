package com.simon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Create Username");
            String user = s.next();
            System.out.println("Create Password");
            String pass = s.next();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "");
            System.out.print("Database is connected !");
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO Signup(username,password,role) " + "VALUES (?, ?,'0')";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2,pass);

            preparedStatement.executeUpdate();

            conn.close();
        }
        catch(Exception e) {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}
