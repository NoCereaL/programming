package com.simon;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
            System.out.println("Connected!!!");
        }catch (Exception e){
            System.out.println("Error");
            System.exit(0);
        }
    }
}
