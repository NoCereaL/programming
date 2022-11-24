package com.simon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "");
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO Signup(username,password,role) " + "VALUES ('Simon', 'Simon','0')";
            statement.executeUpdate(sql);
            System.out.print("Database is connected !");
            conn.close();
        }
        catch(Exception e) {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}
