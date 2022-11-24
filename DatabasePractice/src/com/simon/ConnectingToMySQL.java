package com.simon;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectingToMySQL {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "");
            System.out.println("Connected!");
            conn.close();
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
