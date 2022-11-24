package com.simon;

import java.io.IOException;
import java.sql.*;

public class GetData {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost/login", "root","");
            System.out.println("Connection Successful");

            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT username, password FROM signup WHERE username='Simon'");
            System.out.println("Got Data");

            while (results.next()){
                String name = results.getString("password");
                System.out.println(name);
            }
        } catch (SQLException e){
            System.out.println("Error");
        }
    }
}
